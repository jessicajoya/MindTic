package com.ciclo3.udea.modelos;

public class UsuarioResponse {

    private String mensaje;
    private Object object;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
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
