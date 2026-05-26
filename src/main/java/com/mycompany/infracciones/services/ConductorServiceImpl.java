package com.mycompany.infracciones.services;

import com.mycompany.infracciones.modelo.Conductor;
import com.mycompany.infracciones.repositorio.ConductorRepository;
import org.springframework.stereotype.Service;

@Service
public class ConductorServiceImpl extends BaseServiceImpl<Conductor, Long>
        implements ConductorService {

    public ConductorServiceImpl(ConductorRepository conductorRepository) {
        super(conductorRepository);
    }
}
