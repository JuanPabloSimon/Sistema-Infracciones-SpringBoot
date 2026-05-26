/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

/**
 *
 * @author jsimo
 */
public class Marca {
    private String marcaAuto;
    private Modelo modelo;

    public Marca(String marcaAuto, Modelo modelo) {
        this.marcaAuto = marcaAuto;
        this.modelo = modelo;
    }

    public Marca() {
    }
    
    public String queModelo() {
        return this.modelo.getModeloAuto();
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    
}
