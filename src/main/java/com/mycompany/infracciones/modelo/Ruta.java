/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

/**
 *
 * @author jsimo
 */
public class Ruta {
    private String  nombreRuta;
    private String kmRuta;
    private TipoRuta tipoRuta;

    public Ruta(String nombreRuta, String kmRuta, TipoRuta tipoRuta) {
        this.nombreRuta = nombreRuta;
        this.kmRuta = kmRuta;
        this.tipoRuta = tipoRuta;
    }

    public Ruta() {
    }

    public boolean esRutaInternacional() {
        return this.tipoRuta.esInternacional();
    }
 
    public boolean esRutaNacional() {
        return this.tipoRuta.esNacional();
    }
 
    public boolean esRutaProvincial() {
        return this.tipoRuta.esProvincial();
    }
    
    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getKmRuta() {
        return kmRuta;
    }

    public void setKmRuta(String kmRuta) {
        this.kmRuta = kmRuta;
    }

    public TipoRuta getTipoRuta() {
        return tipoRuta;
    }

    public void setTipoRuta(TipoRuta tipoRuta) {
        this.tipoRuta = tipoRuta;
    }
    
    
    
}
