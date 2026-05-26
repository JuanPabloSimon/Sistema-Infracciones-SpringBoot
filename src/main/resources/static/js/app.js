// NAVEGACION

function mostrarMenu() {
    document.getElementById('seccion-menu').style.display = 'block';
    document.getElementById('seccion-cargar').style.display = 'none';
    document.getElementById('seccion-ver').style.display = 'none';
    document.getElementById('seccion-conductores').style.display = 'none';
}

function mostrarCargar() {
    document.getElementById('seccion-menu').style.display = 'none';
    document.getElementById('seccion-cargar').style.display = 'block';
    document.getElementById('seccion-ver').style.display = 'none';
    document.getElementById('seccion-conductores').style.display = 'none';
    cargarConductores();
    cargarTipos();
    const hoy = new Date().toISOString().split('T')[0];
    document.getElementById('input-fecha').value = hoy;
    document.getElementById('input-fecha').setAttribute('max', hoy);
}

function mostrarVer() {
    document.getElementById('seccion-menu').style.display = 'none';
    document.getElementById('seccion-cargar').style.display = 'none';
    document.getElementById('seccion-ver').style.display = 'block';
    document.getElementById('seccion-conductores').style.display = 'none';
    cargarInfracciones('todas');
}

function mostrarConductores() {
    document.getElementById('seccion-menu').style.display = 'none';
    document.getElementById('seccion-cargar').style.display = 'none';
    document.getElementById('seccion-ver').style.display = 'none';
    document.getElementById('seccion-conductores').style.display = 'block';
    cargarConductoresList();
}

// confirmación carga
function mostrarToast(mensaje, tipo = 'success') {
    const toast = document.getElementById('toast');
    toast.textContent = mensaje;
    toast.className = `toast ${tipo} show`;
    setTimeout(() => { toast.className = 'toast'; }, 3000);
}

// CARGAR CONDUCTORES

async function cargarConductores() {
    try {
        const res = await fetch(`${API_BASE}/conductores`);
        const conductores = await res.json();
        const select = document.getElementById('select-conductor');
        select.innerHTML = '<option value="">Selecciona un conductor...</option>';

        if (conductores.length === 0) {
            select.innerHTML = '<option value="">No hay conductores cargados. Agrega uno con + Nuevo</option>';
            return;
        }

        conductores.forEach(c => {
            const option = document.createElement('option');
            option.value = c.id;
            option.textContent = `${c.nombre} ${c.apellido} - DNI: ${c.dni}`;
            select.appendChild(option);
        });
    } catch (error) {
        mostrarToast('Error al cargar conductores', 'error');
    }
}

// CARGAR CONDUCTORES

async function cargarConductoresList() {
    const tbody = document.getElementById('tabla-conductores-body');
    tbody.innerHTML = '<tr><td colspan="7" class="tabla-vacia"><div class="spinner">Cargando...</div></td></tr>';

    try {
        const res = await fetch(`${API_BASE}/conductores`);
        const conductores = await res.json();
        renderTablaConductores(conductores);
    } catch (error) {
        tbody.innerHTML = '<tr><td colspan="7" class="tabla-vacia">Error al cargar conductores</td></tr>';
    }
}

function renderTablaConductores(conductores) {
    const tbody = document.getElementById('tabla-conductores-body');

    if (conductores.length === 0) {
        tbody.innerHTML = '<tr><td colspan="7" class="tabla-vacia">No hay conductores registrados</td></tr>';
        return;
    }

    tbody.innerHTML = conductores.map(c => `
        <tr>
            <td>${c.id}</td>
            <td><strong>${c.nombre}</strong></td>
            <td>${c.apellido}</td>
            <td>${c.dni}</td>
            <td>${c.domicilio || '-'}</td>
            <td>${c.numeroLicencia || '-'}</td>
            <td>
                <button class="btn btn-secondary"
                        style="padding:6px 12px; font-size:12px;"
                        onclick="eliminarConductor(${c.id})">
                    Eliminar
                </button>
            </td>
        </tr>
    `).join('');
}

async function eliminarConductor(id) {
    if (!confirm('Seguro que queres eliminar este conductor?')) return;

    try {
        const res = await fetch(`${API_BASE}/conductores/${id}`, { method: 'DELETE' });

        if (res.ok) {
            mostrarToast('Conductor eliminado');
            cargarConductoresList();
        } else {
            mostrarToast('Error al eliminar conductor', 'error');
        }
    } catch (error) {
        mostrarToast('Error de conexion', 'error');
    }
}

async function guardarConductorDesdeVista() {
    const nombre    = document.getElementById('vista-nombre').value.trim();
    const apellido  = document.getElementById('vista-apellido').value.trim();
    const dni       = document.getElementById('vista-dni').value.trim();
    const licencia  = document.getElementById('vista-licencia').value.trim();
    const domicilio = document.getElementById('vista-domicilio').value.trim();

    if (!validarCamposConductor(nombre, apellido, dni, licencia, domicilio)) return;

    const conductor = { nombre, apellido, dni: parseInt(dni), numeroLicencia: licencia, domicilio };

    try {
        const res = await fetch(`${API_BASE}/conductores`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(conductor)
        });

        if (res.ok) {
            mostrarToast(`Conductor ${nombre} ${apellido} guardado`);
            toggleFormNuevoConductorVista();
            cargarConductoresList();
        } else if (res.status === 500) {
            mostrarToast('El DNI ya existe en el sistema', 'error');
        } else {
            mostrarToast('Error al guardar conductor', 'error');
        }
    } catch (e) {
        mostrarToast('Error de conexion', 'error');
    }
}

// VALIDACION CONDUCTOR

function validarCamposConductor(nombre, apellido, dni, licencia, domicilio) {
    if (!nombre || nombre.length < 2) {
        mostrarToast('El nombre debe tener al menos 2 caracteres', 'error');
        return false;
    }
    if (!apellido || apellido.length < 2) {
        mostrarToast('El apellido debe tener al menos 2 caracteres', 'error');
        return false;
    }
    if (!dni || isNaN(dni) || parseInt(dni) < 1000000 || parseInt(dni) > 99999999) {
        mostrarToast('El DNI debe tener entre 7 y 8 digitos', 'error');
        return false;
    }
    if (!licencia || licencia.length < 3) {
        mostrarToast('El numero de licencia debe tener al menos 3 caracteres', 'error');
        return false;
    }
    if (!domicilio || domicilio.length < 5) {
        mostrarToast('El domicilio debe tener al menos 5 caracteres', 'error');
        return false;
    }
    return true;
}

// CARGAR TIPOS DE INFRACCION

async function cargarTipos() {
    try {
        const res = await fetch(`${API_BASE}/tipos`);
        const tipos = await res.json();
        const grid = document.getElementById('tipos-grid');
        grid.innerHTML = '';

        tipos.forEach(tipo => {
            const badgeClass = tipo.tipoGravedad === 'Grave' ? 'badge-grave' :
                tipo.tipoGravedad === 'Media' ? 'badge-media' : 'badge-leve';

            const div = document.createElement('div');
            div.className = 'tipo-item';
            div.innerHTML = `
                <input type="checkbox" id="tipo-${tipo.id}" value="${tipo.id}">
                <label for="tipo-${tipo.id}" style="cursor:pointer; flex:1;">
                    ${tipo.descripcion}
                </label>
                <span class="tipo-badge ${badgeClass}">${tipo.tipoGravedad}</span>
            `;

            div.addEventListener('click', (e) => {
                if (e.target.tagName !== 'INPUT') {
                    const checkbox = div.querySelector('input');
                    checkbox.checked = !checkbox.checked;
                }
                div.classList.toggle('seleccionado', div.querySelector('input').checked);
            });

            grid.appendChild(div);
        });
    } catch (error) {
        mostrarToast('Error al cargar tipos de infraccion', 'error');
    }
}

// GUARDAR INFRACCION

async function guardarInfraccion(event) {
    if (event) event.preventDefault();

    const conductorId = document.getElementById('select-conductor').value;
    const descripcion = document.getElementById('input-descripcion').value.trim();
    const importe = document.getElementById('input-importe').value;
    const fecha = document.getElementById('input-fecha').value;
    const hoy = new Date().toISOString().split('T')[0];

    if (!conductorId) {
        mostrarToast('Selecciona un conductor', 'error');
        document.getElementById('select-conductor').focus();
        return;
    }

    if (descripcion && descripcion.length < 5) {
        mostrarToast('La descripcion debe tener al menos 5 caracteres', 'error');
        document.getElementById('input-descripcion').focus();
        return;
    }

    if (!importe || parseFloat(importe) <= 0) {
        mostrarToast('El importe debe ser mayor a 0', 'error');
        document.getElementById('input-importe').focus();
        return;
    }

    if (!fecha) {
        mostrarToast('La fecha es obligatoria', 'error');
        document.getElementById('input-fecha').focus();
        return;
    }
    if (fecha > hoy) {
        mostrarToast('La fecha no puede ser futura', 'error');
        document.getElementById('input-fecha').focus();
        return;
    }

    const checkboxes = document.querySelectorAll('#tipos-grid input[type="checkbox"]:checked');
    const tipos = Array.from(checkboxes).map(cb => ({ id: parseInt(cb.value) }));

    if (tipos.length === 0) {
        mostrarToast('Selecciona al menos un tipo de infraccion', 'error');
        return;
    }

    const infraccion = {
        descripcion: descripcion,
        importe: parseFloat(importe),
        fecha: fecha,
        conductor: { id: parseInt(conductorId) },
        tipos: tipos
    };

    try {
        const res = await fetch(`${API_BASE}/infracciones`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(infraccion)
        });

        if (res.ok) {
            mostrarToast('Infraccion guardada correctamente');
            document.getElementById('form-infraccion').reset();
            document.querySelectorAll('.tipo-item').forEach(item => {
                item.classList.remove('seleccionado');
                item.querySelector('input').checked = false;
            });
            const hoyReset = new Date().toISOString().split('T')[0];
            document.getElementById('input-fecha').value = hoyReset;
            document.getElementById('input-fecha').setAttribute('max', hoyReset);
            setTimeout(() => mostrarVer(), 1500);
        } else {
            mostrarToast('Error al guardar la infraccion', 'error');
        }
    } catch (error) {
        mostrarToast('Error de conexion con el servidor', 'error');
    }
}

// VER Y FILTRAR INFRACCIONES

let infraccionesCache = [];

async function cargarInfracciones(filtro) {
    const tbody = document.getElementById('tabla-body');
    tbody.innerHTML = '<tr><td colspan="8" class="tabla-vacia"><div class="spinner">Cargando...</div></td></tr>';

    try {
        let url = `${API_BASE}/infracciones`;
        if (filtro !== 'todas') {
            url = `${API_BASE}/infracciones/tipo/${filtro}`;
        }

        const res = await fetch(url);
        const infracciones = await res.json();
        infraccionesCache = infracciones;
        actualizarContadores(infracciones);
        renderTabla(infracciones);
    } catch (error) {
        tbody.innerHTML = '<tr><td colspan="8" class="tabla-vacia">Error al cargar infracciones</td></tr>';
    }
}

// CONTADORES

function actualizarContadores(infracciones) {
    const total  = infracciones.length;
    const graves = infracciones.filter(i =>
        i.tipos && i.tipos.some(t => t.tipoGravedad === 'Grave')).length;
    const medias = infracciones.filter(i =>
        i.tipos && i.tipos.some(t => t.tipoGravedad === 'Media') &&
        !i.tipos.some(t => t.tipoGravedad === 'Grave')).length;
    const leves  = infracciones.filter(i =>
        i.tipos && i.tipos.every(t => t.tipoGravedad === 'Leve')).length;

    const contadorEl = document.getElementById('contadores');
    if (contadorEl) {
        contadorEl.innerHTML = `
            <span class="contador-badge total">Total: ${total}</span>
            <span class="contador-badge grave">Graves: ${graves}</span>
            <span class="contador-badge media">Medias: ${medias}</span>
            <span class="contador-badge leve">Leves: ${leves}</span>
        `;
    }
}

// RENDER TABLA INFRACCIONES

function renderTabla(infracciones) {
    const tbody = document.getElementById('tabla-body');

    if (infracciones.length === 0) {
        tbody.innerHTML = '<tr><td colspan="8" class="tabla-vacia">No hay infracciones para mostrar</td></tr>';
        return;
    }

    tbody.innerHTML = infracciones.map(inf => {
        const conductor = inf.conductor
            ? `${inf.conductor.nombre} ${inf.conductor.apellido}`
            : '-';
        const dni = inf.conductor ? inf.conductor.dni : '-';

        const tipos = inf.tipos && inf.tipos.length > 0
            ? inf.tipos.map(t => {
                const chipClass = t.tipoGravedad === 'Grave' ? 'chip-grave' :
                    t.tipoGravedad === 'Media' ? 'chip-media' : 'chip-leve';
                return `<span class="chip ${chipClass}">${t.descripcion}</span>`;
            }).join('')
            : '-';

        const importe = new Intl.NumberFormat('es-AR', {
            style: 'currency', currency: 'ARS'
        }).format(inf.importe);

        const fecha = new Date(inf.fecha + 'T00:00:00').toLocaleDateString('es-AR');

        return `
            <tr>
                <td>${inf.id}</td>
                <td><strong>${conductor}</strong></td>
                <td>${dni}</td>
                <td>${inf.descripcion || '-'}</td>
                <td>${tipos}</td>
                <td><strong>${importe}</strong></td>
                <td>${fecha}</td>
                <td>
                    <button class="btn btn-secondary"
                            style="padding:6px 12px; font-size:12px;"
                            onclick="eliminarInfraccion(${inf.id})">
                        Eliminar
                    </button>
                </td>
            </tr>
        `;
    }).join('');
}

// FILTRAR

function filtrar(tipo, btn) {
    document.querySelectorAll('.btn-filtro').forEach(b => b.classList.remove('activo'));
    btn.classList.add('activo');
    cargarInfracciones(tipo);
}

// ELIMINAR INFRACCION

async function eliminarInfraccion(id) {
    if (!confirm('Seguro que queres eliminar esta infraccion?')) return;

    try {
        const res = await fetch(`${API_BASE}/infracciones/${id}`, {
            method: 'DELETE'
        });

        if (res.ok) {
            mostrarToast('Infraccion eliminada');
            cargarInfracciones('todas');
            document.querySelectorAll('.btn-filtro').forEach(b => b.classList.remove('activo'));
            document.querySelector('.btn-filtro').classList.add('activo');
        } else {
            mostrarToast('Error al eliminar', 'error');
        }
    } catch (error) {
        mostrarToast('Error de conexion', 'error');
    }
}
