package com.MindTic.MindTic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MovimientosDinero")
public class MovimientosDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Float monto;

    @Column
    private int tipoMovimiento;

    @Column
    private String conceptoMovimiento;

    @Column
    private Date fechaCreacion;

    @Column
    private Date fechaActual;

    @OneToOne
    private Empleados empleados;


    public MovimientosDinero(int id, float monto, int tipoMovimiento, String conceptoMovimiento, Date fechaCreacion, Date fechaActual, Empleados empleados) {
        this.id = id;
        this.monto = monto;
        this.tipoMovimiento = tipoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.fechaCreacion = fechaCreacion;
        this.fechaActual = fechaActual;
        this.empleados = empleados;
    }

    public MovimientosDinero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
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

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }
}
