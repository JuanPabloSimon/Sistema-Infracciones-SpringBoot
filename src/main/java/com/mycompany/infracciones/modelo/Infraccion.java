package com.mycompany.infracciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "infraccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Infraccion extends Base {

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "importe", nullable = false)
    private Double importe;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_conductor")
    private Conductor conductor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "infraccion_tipo",
            joinColumns = @JoinColumn(name = "idInfraccion"),
            inverseJoinColumns = @JoinColumn(name = "idTipoInfraccion")
    )
    private List<TipoDeInfraccion> tipos = new ArrayList<>();
}
