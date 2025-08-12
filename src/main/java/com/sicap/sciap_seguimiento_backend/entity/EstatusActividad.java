package com.sicap.sciap_seguimiento_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "estatus_actividad")
public class EstatusActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estatus_actividad")
    private Integer idEstatusActividad;

    @Column(name = "nombre_estatus")
    private String nombreEstatus;

    @Column(name = "color")
    private String color;

    @Column(name = "activo")
    private String activo;
}