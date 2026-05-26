/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

import java.time.LocalDate;

/**
 *
 * @author jsimo
 */
public class Licencia {
    private int idLicencia;
    private LocalDate fechaVto;
    private  int puntosInicialesLicencia;
    private Conductor conductor = new Conductor();

    public Licencia(int idLicencia, LocalDate fechaVto, int puntosInicialesLicencia) {
        this.idLicencia = idLicencia;
        this.fechaVto = fechaVto;
        this.puntosInicialesLicencia = puntosInicialesLicencia;
    }

    public Licencia() {
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public LocalDate getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(LocalDate fechaVto) {
        this.fechaVto = fechaVto;
    }

    public int getPuntosInicialesLicencia() {
        return puntosInicialesLicencia;
    }

    public void setPuntosInicialesLicencia(int puntosInicialesLicencia) {
        this.puntosInicialesLicencia = puntosInicialesLicencia;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    
    
    
    
}
