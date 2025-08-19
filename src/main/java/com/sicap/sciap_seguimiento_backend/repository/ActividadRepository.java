package com.sicap.sciap_seguimiento_backend.repository;

import com.sicap.sciap_seguimiento_backend.dto.ActividadDTO;
import com.sicap.sciap_seguimiento_backend.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
    @Query(
            value = "SELECT a.id_actividad, a.id_grupo, a.usuario_creador, a.nombre_actividad, a.id_estatus_actividad, " +
                    "DATE_FORMAT(a.fecha_inicio,'%d/%m/%Y') as fecha_inicio_format, " +
                    "DATE_FORMAT(a.fecha_fin,'%d/%m/%Y') as fecha_fin_format, " +
                    "a.fecha_inicio, a.fecha_fin, IFNULL(a.horas_cotizadas,0) AS horas_cotizadas, " +
                    "IFNULL(a.horas_ejecutadas,0) AS horas_ejecutadas, a.porcentaje, a.notas, a.privacidad, a.activo, " +
                    "a.fecha_creacion, a.fecha_modificacion, a.estatus_notificacion, " +
                    "(SELECT IFNULL(SUM(ra.horas),0) FROM reporte_actividades AS ra WHERE ra.id_actividad = a.id_actividad) AS suma_hrs_ejecutadas, " +
                    "(SELECT color FROM estatus_actividad WHERE estatus_actividad.id_estatus_actividad = a.id_estatus_actividad) AS color_estatus, " +
                    "(SELECT nombre_estatus FROM estatus_actividad WHERE estatus_actividad.id_estatus_actividad = a.id_estatus_actividad) AS nombre_estatus, " +
                    "(SELECT id_tipo_usuario FROM usuarios WHERE usuarios.id_usuario = a.usuario_creador) as tipo_usuario, " +
                    "(SELECT costo_por_hora FROM usuarios WHERE usuarios.id_usuario = a.usuario_creador) as costo_por_hora, " +
                    "(SELECT id_usuario FROM usuarios_actividad WHERE usuarios_actividad.id_actividad = a.id_actividad GROUP BY usuarios_actividad.id_usuario) AS usuario_asignado, " +
                    "IFNULL((SELECT CONCAT(nombre,' ',apellido_paterno,' ',apellido_materno) FROM usuarios WHERE usuarios.id_usuario = (SELECT id_usuario FROM usuarios_actividad WHERE usuarios_actividad.id_actividad = a.id_actividad GROUP BY usuarios_actividad.id_usuario)), '') AS nombre_usuario_asignado " +
                    "FROM actividades a WHERE a.id_grupo = :idGrupo AND a.activo = 1 ORDER BY a.nombre_actividad ASC",
            nativeQuery = true)
    List<Object[]> findActividadesByGrupo(@Param("idGrupo") Long idGrupo);
}
