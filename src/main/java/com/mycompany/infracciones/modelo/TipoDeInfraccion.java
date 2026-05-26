package com.mycompany.infracciones.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_infraccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDeInfraccion extends Base {

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "tipo_gravedad", nullable = false)
    private String tipoGravedad; // "Grave", "Media", "Leve"

    @Column(name = "importe_base", nullable = false)
    private Double importeBase;

    @Column(name = "porcentaje_descuento")
    private Double porcentajeDescuento;
}
