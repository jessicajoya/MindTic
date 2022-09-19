package com.ciclo3.udea.modelos;


import javax.persistence.*;


@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    //objeto de tipo Empresa que se llama empresa, es una asociacion de uno a muchos

    private String rol;

    //constructor vacio para pruebas
    public Empleado() {
    }

    public Empleado(String nombre, String correo, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


}
