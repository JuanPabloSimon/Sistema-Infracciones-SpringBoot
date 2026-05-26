package com.mycompany.infracciones.controlador;

import com.mycompany.infracciones.modelo.Conductor;
import com.mycompany.infracciones.services.ConductorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/conductores")
public class ConductorController extends BaseControllerImpl<Conductor, ConductorServiceImpl> {
}
