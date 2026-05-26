package com.mycompany.infracciones.services;

import com.mycompany.infracciones.modelo.Infraccion;
import com.mycompany.infracciones.modelo.TipoDeInfraccion;
import com.mycompany.infracciones.repositorio.InfraccionRepository;
import com.mycompany.infracciones.repositorio.TipoDeInfraccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfraccionServiceImpl extends BaseServiceImpl<Infraccion, Long>
        implements InfraccionService {

    private final InfraccionRepository infraccionRepository;
    private final TipoDeInfraccionRepository tipoRepository;

    public InfraccionServiceImpl(InfraccionRepository infraccionRepository,
                                 TipoDeInfraccionRepository tipoRepository) {
        super(infraccionRepository);
        this.infraccionRepository = infraccionRepository;
        this.tipoRepository = tipoRepository;
    }

    @Transactional
    @Override
    public Infraccion save(Infraccion infraccion) throws Exception {
        try {
            // Resolver los tipos desde la base para evitar entidades detached
            if (infraccion.getTipos() != null && !infraccion.getTipos().isEmpty()) {
                List<TipoDeInfraccion> tiposResueltos = new ArrayList<>();
                for (TipoDeInfraccion tipo : infraccion.getTipos()) {
                    TipoDeInfraccion tipoReal = tipoRepository.findById(tipo.getId())
                            .orElseThrow(() -> new Exception(
                                    "Tipo de infraccion no encontrado: " + tipo.getId()));
                    tiposResueltos.add(tipoReal);
                }
                infraccion.setTipos(tiposResueltos);
            }
            return infraccionRepository.save(infraccion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public List<Infraccion> findByTipoGravedad(String tipoGravedad) throws Exception {
        try {
            return infraccionRepository.findByTipoGravedad(tipoGravedad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public List<Infraccion> findByConductorId(Long conductorId) throws Exception {
        try {
            return infraccionRepository.findByConductorId(conductorId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
