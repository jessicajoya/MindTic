package com.MindTic.MindTic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombreCompleto;

    @Column
    private String email;
    @OneToOne
    private Rol rol;
    @OneToOne
    private Empresas empresas;

    @JsonIgnore
    @OneToOne(mappedBy = "empleados")
    private MovimientosDinero movimientosDinero;

    @Column
    private Date fechaCreacion;

    @Column
    private Date fechaActual;


    public Empleados(int id, String nombreCompleto, String email, Rol rol, Empresas empresas, MovimientosDinero movimientosDinero, Date fechaCreacion, Date fechaActual) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.rol = rol;
        this.empresas = empresas;
        this.fechaCreacion = fechaCreacion;
        this.fechaActual = fechaActual;
        this.movimientosDinero =movimientosDinero;
    }

    public Empleados() {

    }

    public MovimientosDinero getMovimientosDinero() {
        return movimientosDinero;
    }

    public void setMovimientosDinero(MovimientosDinero movimientosDinero) {
        this.movimientosDinero = movimientosDinero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
}
