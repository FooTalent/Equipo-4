package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.entity.FamiliaEntity;

import java.util.HashMap;
import java.util.Map;

public class MentoriaMapperManual {

    public static MentoriaDTO mentoriaToDto(MentoriaEntity mentoria) {
        MentoriaDTO dto = new MentoriaDTO();

        Map<String, Object> familiaMentora = new HashMap<>();
        familiaMentora.put("id", mentoria.getId());
        familiaMentora.put("nombre", mentoria.getFamiliaMentora().getNombreFaUno());
        dto.setFamiliaMentora(familiaMentora);

        Map<String, Object> familiaMentorada = new HashMap<>();
        familiaMentorada.put("id", mentoria.getFamiliaMentorada().getId());
        familiaMentorada.put("nombre", mentoria.getFamiliaMentorada().getNombreFaUno());
        dto.setFamiliaMentorada(familiaMentorada);

        dto.setId(mentoria.getId());
        dto.setEstadoMentoria(mentoria.getEstadoMentoria());
        dto.setFechaAsignacion(mentoria.getFechaAsignacion());

        return dto;
    }

    public static MentoriaEntity mentoriaToEntity(MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoria = new MentoriaEntity();

        mentoria.setFechaAsignacion(mentoriaDTO.getFechaAsignacion());
        mentoria.setEstadoMentoria(mentoriaDTO.getEstadoMentoria());

        Map<String, Object> familiaMentora = mentoriaDTO.getFamiliaMentora();
        if (familiaMentora != null && familiaMentora.get("familiaMentoraId") != null) {
            FamiliaEntity familiaMentoraEntity = new FamiliaEntity();
            familiaMentoraEntity.setId((Long) familiaMentora.get("familiaMentoraId"));
            mentoria.setFamiliaMentora(familiaMentoraEntity);
        }

        Map<String, Object> familiaMentorada = mentoriaDTO.getFamiliaMentorada();
        if (familiaMentorada != null && familiaMentorada.get("familiaMentoradaId") != null) {
            FamiliaEntity familiaMentoradaEntity = new FamiliaEntity();
            familiaMentoradaEntity.setId((Long) familiaMentorada.get("familiaMentoradaId"));
            mentoria.setFamiliaMentorada(familiaMentoradaEntity);
        }

        return mentoria;
    }

    public static void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, MentoriaEntity mentoria) {
        mentoria.setEstadoMentoria(mentoriaDTO.getEstadoMentoria());
        mentoria.setFechaAsignacion(mentoriaDTO.getFechaAsignacion());

        // Actualizar la relación con FamiliaEntity
        Map<String, Object> familiaMentora = mentoriaDTO.getFamiliaMentora();
        if (familiaMentora != null && familiaMentora.get("familiaMentoraId") != null) {
            FamiliaEntity familiaMentoraEntity = new FamiliaEntity();
            familiaMentoraEntity.setId((Long) familiaMentora.get("familiaMentoraId"));
            mentoria.setFamiliaMentora(familiaMentoraEntity);
        }

        Map<String, Object> familiaMentorada = mentoriaDTO.getFamiliaMentorada();
        if (familiaMentorada != null && familiaMentorada.get("familiaMentoradaId") != null) {
            FamiliaEntity familiaMentoradaEntity = new FamiliaEntity();
            familiaMentoradaEntity.setId((Long) familiaMentorada.get("familiaMentoradaId"));
            mentoria.setFamiliaMentorada(familiaMentoradaEntity);
        }
    }
}