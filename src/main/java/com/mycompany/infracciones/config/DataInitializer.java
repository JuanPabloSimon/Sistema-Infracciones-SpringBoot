package com.mycompany.infracciones.config;

import com.mycompany.infracciones.modelo.TipoDeInfraccion;
import com.mycompany.infracciones.repositorio.TipoDeInfraccionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TipoDeInfraccionRepository tipoRepository;

    public DataInitializer(TipoDeInfraccionRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (tipoRepository.count() == 0) {
            tipoRepository.save(new TipoDeInfraccion("Exceso velocidad", "Grave", 790000.0, 10.0));
            tipoRepository.save(new TipoDeInfraccion("Sin cinturon de seguridad", "Grave", 543344.0, 0.0));
            tipoRepository.save(new TipoDeInfraccion("Semáforo en rojo", "Media", 23423.0, 10.0));
            tipoRepository.save(new TipoDeInfraccion("Uso del celular", "Grave", 1500000.0, 5.0));
            tipoRepository.save(new TipoDeInfraccion("Estacionamiento prohibido", "Leve", 64000.0, 10.0));
            tipoRepository.save(new TipoDeInfraccion("Luces apagadas", "Leve", 25000.0, 20.0));
            tipoRepository.save(new TipoDeInfraccion("Documentación incompleta", "Leve", 13000.0, 20.0));
            tipoRepository.save(new TipoDeInfraccion("Alcoholemia positiva", "Grave", 1000000.0, 0.0));
            tipoRepository.save(new TipoDeInfraccion("Sin licencia de conducir", "Media", 99000.0, 0.0));
        } else {
            System.out.println("Los tipos de infraccion ya estaban cargados.");
        }
    }
}
