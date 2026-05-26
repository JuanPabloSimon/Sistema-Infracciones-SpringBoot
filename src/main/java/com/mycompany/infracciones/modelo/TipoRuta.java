/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

/**
 *
 * @author jsimo
 */
public class TipoRuta {
    private String descTipoRuta;
    private String nombreTipoRuta;

    public TipoRuta(String descTipoRuta, String nombreTipoRuta) {
        this.descTipoRuta = descTipoRuta;
        this.nombreTipoRuta = nombreTipoRuta;
    }

    public TipoRuta() {
    }

    public boolean esInternacional() {
        return true;
    }
 
    public boolean esNacional() {
        return true;
    }
 
    public boolean esProvincial() {
        return true;
    }
 
    public String getDescTipoRuta() {
        return descTipoRuta;
    }

    public void setDescTipoRuta(String descTipoRuta) {
        this.descTipoRuta = descTipoRuta;
    }

    public String getNombreTipoRuta() {
        return nombreTipoRuta;
    }

    public void setNombreTipoRuta(String nombreTipoRuta) {
        this.nombreTipoRuta = nombreTipoRuta;
    }
    
    
    
}
