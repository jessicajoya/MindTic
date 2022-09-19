package com.ciclo3.udea.modelos;

import javax.persistence.*;

@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @Column
    private String nombreUsuario;

    @Column
    private String password;

    @Column
    private String nombrePersona;

    public Usuario(String nombreUsuario, String password, String nombrePersona) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombrePersona = nombrePersona;
    }

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}


