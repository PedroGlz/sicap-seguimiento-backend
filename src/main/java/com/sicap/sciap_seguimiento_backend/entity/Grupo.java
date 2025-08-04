package com.sicap.sciap_seguimiento_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @ManyToOne(optional = true)
    @JoinColumn(
            name = "id_proyecto",
            referencedColumnName = "id_proyecto",
            nullable = true,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Proyecto proyecto;

    @Column(name = "nombre_grupo")
    private String nombreGrupo;

    @Column(name = "color_grupo")
    private String colorGrupo;

    @Column(name = "estatus_colapso")
    private String estatusColapso;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "usuario_creador")
    private Integer usuarioCreador;

    @Column(name = "privacidad")
    private String privacidad;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    // Getters y setters...
}