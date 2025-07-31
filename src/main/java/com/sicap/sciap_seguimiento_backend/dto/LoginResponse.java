package com.sicap.sciap_seguimiento_backend.dto;

public class LoginResponse {
    private Long idUsuario;
    private String nombre;
    private String nombreCompleto;
    private String numeroEmpleado;
    private String usuario;
    private String correo;
    private String telefono;
    private Long idTipoUsuario;
    private Double costoPorHora;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(Double costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

}
