/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

/**
 *
 * @author jsimo
 */
public class EstadoDelActa {
    private String descripcionEstadoActa;
    private String nombreEstadoActa;

    public EstadoDelActa(String descripcionEstadoActa, String nombreEstadoActa) {
        this.descripcionEstadoActa = descripcionEstadoActa;
        this.nombreEstadoActa = nombreEstadoActa;
    }

    public EstadoDelActa() {
    }

    public String getDescripcionEstadoActa() {
        return descripcionEstadoActa;
    }

    public void setDescripcionEstadoActa(String descripcionEstadoActa) {
        this.descripcionEstadoActa = descripcionEstadoActa;
    }

    public String getNombreEstadoActa() {
        return nombreEstadoActa;
    }

    public void setNombreEstadoActa(String nombreEstadoActa) {
        this.nombreEstadoActa = nombreEstadoActa;
    }
    
    
}
