/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

/**
 *
 * @author jsimo
 */
public class AutoridadDeConstatacion extends Persona {
    private int idPlaca;
    private int idLegajo;

    public AutoridadDeConstatacion(int idPlaca, int idLegajo, int dni, String nombre, String apellido, String genero) {
        super(dni, nombre, apellido, genero);
        this.idPlaca = idPlaca;
        this.idLegajo = idLegajo;
    }

    public AutoridadDeConstatacion(int idPlaca, String nombre, String apellido) {
        super(nombre, apellido);
        this.idPlaca = idPlaca;
    }

    public int getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(int idPlaca) {
        this.idPlaca = idPlaca;
    }

    public int getIdLegajo() {
        return idLegajo;
    }

    public void setIdLegajo(int idLegajo) {
        this.idLegajo = idLegajo;
    }
    
    
    
}
