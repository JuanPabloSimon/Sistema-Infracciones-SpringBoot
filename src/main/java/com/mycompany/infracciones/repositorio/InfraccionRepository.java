package com.mycompany.infracciones.repositorio;

import com.mycompany.infracciones.modelo.Infraccion;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfraccionRepository extends BaseRepository<Infraccion, Long> {

    @Query("SELECT i FROM Infraccion i JOIN i.tipos t WHERE t.tipoGravedad = ?1")
    List<Infraccion> findByTipoGravedad(String tipoGravedad);

    @Query("SELECT i FROM Infraccion i WHERE i.conductor.id = ?1")
    List<Infraccion> findByConductorId(Long conductorId);
}
