package com.sicap.sciap_seguimiento_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupo;

    @Column(name = "nombre_actividad")
    private String nombreActividad;

    @ManyToOne
    @JoinColumn(name = "id_estatus_actividad", referencedColumnName = "id_estatus_actividad")
    private EstatusActividad estatusActividad;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "horas_cotizadas")
    private Float horasCotizadas;

    @Column(name = "horas_ejecutadas")
    private Float horasEjecutadas;

    @Column(name = "notas")
    private String notas;

    @Column(name = "estatus_notificacion")
    private String estatusNotificacion;

    @Column(name = "usuario_creador")
    private Integer usuarioCreador;

    @Column(name = "privacidad")
    private String privacidad;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "porcentaje")
    private Integer porcentaje;
}