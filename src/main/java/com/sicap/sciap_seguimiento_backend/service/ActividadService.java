package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.dto.ActividadDTO;
import com.sicap.sciap_seguimiento_backend.entity.Actividad;
import com.sicap.sciap_seguimiento_backend.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> findById(Integer id) {
        return actividadRepository.findById(id);
    }

    public List<ActividadDTO> getActividadesPorGrupo(Long idGrupo) {
        List<Object[]> rows = actividadRepository.findActividadesByGrupo(idGrupo);
        List<ActividadDTO> actividades = new ArrayList<>();

        for (Object[] row : rows) {
            ActividadDTO dto = new ActividadDTO();

            dto.setIdActividad(row[0] != null ? parseLong(row[0]) : null);
            dto.setIdGrupo(row[1] != null ? parseLong(row[1]) : null);
            dto.setUsuarioCreador(row[2] != null ? parseLong(row[2]) : null);
            dto.setNombreActividad(row[3] != null ? row[3].toString() : null);
            dto.setIdEstatusActividad(row[4] != null ? parseInteger(row[4]) : null);
            dto.setFechaInicioFormat(row[5] != null ? row[5].toString() : null);
            dto.setFechaFinFormat(row[6] != null ? row[6].toString() : null);
            dto.setFechaInicio(row[7] != null ? row[7].toString() : null);
            dto.setFechaFin(row[8] != null ? row[8].toString() : null);
            dto.setHorasCotizadas(row[9] != null ? parseDouble(row[9]) : null);
            dto.setHorasEjecutadas(row[10] != null ? parseDouble(row[10]) : null);
            dto.setPorcentaje(row[11] != null ? parseInteger(row[11]) : null);
            dto.setNotas(row[12] != null ? row[12].toString() : null);
            dto.setPrivacidad(row[13] != null ? parseInteger(row[13]) : null);
            dto.setActivo(row[14] != null ? parseInteger(row[14]) : null);
            dto.setFechaCreacion(row[15] != null ? row[15].toString() : null);
            dto.setFechaModificacion(row[16] != null ? row[16].toString() : null);
            dto.setEstatusNotificacion(row[17] != null ? parseInteger(row[17]) : null);
            dto.setSumaHrsEjecutadas(row[18] != null ? parseDouble(row[18]) : null);
            dto.setColorEstatus(row[19] != null ? row[19].toString() : null);
            dto.setNombreEstatus(row[20] != null ? row[20].toString() : null);
            dto.setTipoUsuario(row[21] != null ? parseInteger(row[21]) : null);
            dto.setCostoPorHora(row[22] != null ? parseDouble(row[22]) : null);
            dto.setUsuarioAsignado(row[23] != null ? parseLong(row[23]) : null);
            dto.setNombreUsuarioAsignado(row[24] != null ? row[24].toString() : null);

            actividades.add(dto);
        }

        return actividades;
    }

    // Métodos de parseo seguro
    private Long parseLong(Object obj) {
        try {
            return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }

    private Integer parseInteger(Object obj) {
        try {
            return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }

    private Double parseDouble(Object obj) {
        try {
            return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }


    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public void deleteById(Integer id) {
        actividadRepository.deleteById(id);
    }
}
