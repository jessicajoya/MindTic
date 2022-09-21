package com.MindTic.MindTic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String tipoRol;

    @JsonIgnore
    @OneToOne(mappedBy = "rol")
    private Empleados empleados;

    public Rol(int id, String tipoRol) {
        this.id = id;
        this.tipoRol = tipoRol;
    }

    public Rol() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }
}
