package com.ciclo3.udea.modelos;


import javax.persistence.*;

@Entity
@Table(name="Empresa")

public class Empresa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nombre;
    private String dirección;
    private String telefono;
    private String NIT;

    public Empresa() {
    }

    public Empresa(String nombre, String dirección, String telefono, String NIT) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}


