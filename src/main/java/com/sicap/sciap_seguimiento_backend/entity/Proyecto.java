package com.sicap.sciap_seguimiento_backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "po")
    private String po;

    @Column(name = "usuario_creador")
    private Integer usuarioCreador;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "privacidad")
    private String privacidad;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Getters y setters
    // ...
}