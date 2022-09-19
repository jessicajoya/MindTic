package com.ciclo3.udea.modelos;


import javax.persistence.*;

@Entity
@Table(name = "Movimientos")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private long monto;
    private  String concepto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private  Empleado usuario;
    //usuario Corresponde a un objeto de la clase empleado, tiene una relacion de muchos a uno
    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, String concepto, Empleado usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

}
