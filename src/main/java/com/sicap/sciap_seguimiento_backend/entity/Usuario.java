package com.sicap.sciap_seguimiento_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @Column(name = "apellido_paterno", length = 70)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 70)
    private String apellidoMaterno;

    @Column(name = "numero_empleado", length = 30)
    private String numeroEmpleado;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "costo_por_hora")
    private Double costoPorHora;

}