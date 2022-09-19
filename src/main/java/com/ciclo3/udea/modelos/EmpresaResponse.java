package com.ciclo3.udea.modelos;

public class EmpresaResponse {
    private String mensaje;
    private Object object;

    public EmpresaResponse() {
    }

    public EmpresaResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
