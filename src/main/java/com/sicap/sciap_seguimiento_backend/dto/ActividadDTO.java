package com.sicap.sciap_seguimiento_backend.dto;
import lombok.Data;

@Data
public class ActividadDTO {
    private Long idActividad;
    private Long idGrupo;
    private Long usuarioCreador;
    private String nombreActividad;
    private Integer idEstatusActividad;
    private String fechaInicioFormat;
    private String fechaFinFormat;
    private String fechaInicio;
    private String fechaFin;
    private Double horasCotizadas;
    private Double horasEjecutadas;
    private Integer porcentaje;
    private String notas;
    private Integer privacidad;
    private Integer activo;
    private String fechaCreacion;
    private String fechaModificacion;
    private Integer estatusNotificacion;
    private Double sumaHrsEjecutadas;
    private String colorEstatus;
    private String nombreEstatus;
    private Integer tipoUsuario;
    private Double costoPorHora;
    private Long usuarioAsignado;
    private String nombreUsuarioAsignado;
}