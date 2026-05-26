package com.mycompany.infracciones.services;

import com.mycompany.infracciones.modelo.Infraccion;

import java.util.List;

public interface InfraccionService extends BaseService<Infraccion, Long> {

    List<Infraccion> findByTipoGravedad(String tipoGravedad) throws Exception;

    List<Infraccion> findByConductorId(Long conductorId) throws Exception;
}
