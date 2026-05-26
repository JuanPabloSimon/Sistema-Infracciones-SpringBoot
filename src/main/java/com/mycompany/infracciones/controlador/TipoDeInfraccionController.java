package com.mycompany.infracciones.controlador;

import com.mycompany.infracciones.modelo.TipoDeInfraccion;
import com.mycompany.infracciones.services.TipoDeInfraccionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tipos")
public class TipoDeInfraccionController extends BaseControllerImpl<TipoDeInfraccion, TipoDeInfraccionServiceImpl> {
}
