package com.MindTic.MindTic.models;

public class EmpresasResponse {

    private String mensaje;
    private Object object;

    public EmpresasResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public EmpresasResponse() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
