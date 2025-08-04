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

    // Relación con Cliente
    @ManyToOne(optional = true)
    @JoinColumn(
            name = "id_cliente",
            referencedColumnName = "id_cliente",
            nullable = true,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Cliente cliente;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

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

    // Métodos para exponer nombre_cliente y ubicacion
    public String getNombreCliente() {
        return cliente != null ? cliente.getNombreCliente() : null;
    }

    public String getUbicacionCliente() {
        return cliente != null ? cliente.getUbicacion() : null;
    }
}