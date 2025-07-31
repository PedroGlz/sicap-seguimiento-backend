package com.sicap.sciap_seguimiento_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre_cliente", length = 70)
    private String nombreCliente;

    @Column(name = "ubicacion", length = 90)
    private String ubicacion;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Getters y setters
    // ...


}