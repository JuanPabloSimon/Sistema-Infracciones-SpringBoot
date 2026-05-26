package com.mycompany.infracciones.controlador;

import com.mycompany.infracciones.modelo.Infraccion;
import com.mycompany.infracciones.services.InfraccionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/infracciones")
public class InfraccionController extends BaseControllerImpl<Infraccion, InfraccionServiceImpl> {

    @GetMapping("/tipo/{tipoGravedad}")
    public ResponseEntity<?> getByTipoGravedad(@PathVariable String tipoGravedad) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servicio.findByTipoGravedad(tipoGravedad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/conductor/{id}")
    public ResponseEntity<?> getByConductor(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servicio.findByConductorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }
}
