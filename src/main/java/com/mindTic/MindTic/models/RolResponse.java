package com.MindTic.MindTic.models;

public class RolResponse {

    private String mensaje;
    private Object object;

    public RolResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public RolResponse() {
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
