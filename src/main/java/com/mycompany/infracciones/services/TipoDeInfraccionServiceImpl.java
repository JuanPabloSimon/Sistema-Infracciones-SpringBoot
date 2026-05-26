package com.mycompany.infracciones.services;

import com.mycompany.infracciones.modelo.TipoDeInfraccion;
import com.mycompany.infracciones.repositorio.TipoDeInfraccionRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDeInfraccionServiceImpl extends BaseServiceImpl<TipoDeInfraccion, Long>
        implements TipoDeInfraccionService {

    public TipoDeInfraccionServiceImpl(TipoDeInfraccionRepository tipoRepository) {
        super(tipoRepository);
    }
}
