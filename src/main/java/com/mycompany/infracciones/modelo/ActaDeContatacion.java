/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infracciones.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jsimo
 */
public class ActaDeContatacion {
    private ArrayList<Infraccion> infracciones = new ArrayList<>();
    private LocalDate fechaDeLabrado;
    private LocalDate fechaVtoPago;
    private LocalDate horaDeLabrado;
    private String lugarDeConstatacion;
    private int idActa;
    private String observaciones;
    private Ruta ruta;
    private Licencia licenciaConductor;
    private AutoridadDeConstatacion auroridad;
    private EstadoDelActa estadoActa;
    private Vehiculo vehiculoConductor;
    private OrganizacionEstatal organizacion;

    public ActaDeContatacion(LocalDate fechaDeLabrado, LocalDate fechaVtoPago, LocalDate horaDeLabrado, String lugarDeConstatacion, int idActa, String observaciones, Ruta ruta, Licencia licenciaConductor, AutoridadDeConstatacion auroridad, EstadoDelActa estadoActa, Vehiculo vehiculoConductor, OrganizacionEstatal organizacion) {
        this.fechaDeLabrado = fechaDeLabrado;
        this.fechaVtoPago = fechaVtoPago;
        this.horaDeLabrado = horaDeLabrado;
        this.lugarDeConstatacion = lugarDeConstatacion;
        this.idActa = idActa;
        this.observaciones = observaciones;
        this.ruta = ruta;
        this.licenciaConductor = licenciaConductor;
        this.auroridad = auroridad;
        this.estadoActa = estadoActa;
        this.vehiculoConductor = vehiculoConductor;
        this.organizacion = organizacion;
    }

    public ActaDeContatacion() {
    }
    
    public void agregarInfraccion(Infraccion inf) {
        this.infracciones.add(inf);
    }
    
    public void removerInfraccion(int index) {
        this.infracciones.remove(index);
    }

    public ArrayList<Infraccion> getInfracciones() {
        return infracciones;
    }


    public LocalDate getFechaDeLabrado() {
        return fechaDeLabrado;
    }

    public void setFechaDeLabrado(LocalDate fechaDeLabrado) {
        this.fechaDeLabrado = fechaDeLabrado;
    }

    public LocalDate getFechaVtoPago() {
        return fechaVtoPago;
    }

    public void setFechaVtoPago(LocalDate fechaVtoPago) {
        this.fechaVtoPago = fechaVtoPago;
    }

    public LocalDate getHoraDeLabrado() {
        return horaDeLabrado;
    }

    public void setHoraDeLabrado(LocalDate horaDeLabrado) {
        this.horaDeLabrado = horaDeLabrado;
    }

    public String getLugarDeConstatacion() {
        return lugarDeConstatacion;
    }

    public void setLugarDeConstatacion(String lugarDeConstatacion) {
        this.lugarDeConstatacion = lugarDeConstatacion;
    }

    public int getIdActa() {
        return idActa;
    }

    public void setIdActa(int idActa) {
        this.idActa = idActa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Licencia getLicenciaConductor() {
        return licenciaConductor;
    }

    public void setLicenciaConductor(Licencia licenciaConductor) {
        this.licenciaConductor = licenciaConductor;
    }

    public AutoridadDeConstatacion getAuroridad() {
        return auroridad;
    }

    public void setAuroridad(AutoridadDeConstatacion auroridad) {
        this.auroridad = auroridad;
    }

    public EstadoDelActa getEstadoActa() {
        return estadoActa;
    }

    public void setEstadoActa(EstadoDelActa estadoActa) {
        this.estadoActa = estadoActa;
    }

    public Vehiculo getVehiculoConductor() {
        return vehiculoConductor;
    }

    public void setVehiculoConductor(Vehiculo vehiculoConductor) {
        this.vehiculoConductor = vehiculoConductor;
    }

    public OrganizacionEstatal getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEstatal organizacion) {
        this.organizacion = organizacion;
    }
    
    






}
