package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.entity.FamiliaEntity;

public class MentoriaMapperManual {

    public static MentoriaDTO mentoriaToDto(MentoriaEntity mentoria) {
        MentoriaDTO dto = new MentoriaDTO();
        dto.setId(mentoria.getId());
        dto.setEstadoMentoria(mentoria.getEstadoMentoria());
        dto.setFechaAsignacion(mentoria.getFechaAsignacion());

        if (mentoria.getFamiliaMentora() != null) {
            dto.setFamiliaMentoraId(mentoria.getFamiliaMentora().getId());
        }

        if (mentoria.getFamiliaMentorada() != null) {
            dto.setFamiliaMentoradaId(mentoria.getFamiliaMentorada().getId());
        }

        return dto;
    }

    public static MentoriaEntity mentoriaToEntity(MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoria = new MentoriaEntity();

        mentoria.setFechaAsignacion(mentoriaDTO.getFechaAsignacion());
        mentoria.setEstadoMentoria(mentoriaDTO.getEstadoMentoria());

        // Establecer la relación con FamiliaEntity
        if (mentoriaDTO.getFamiliaMentoraId() != null) {
            FamiliaEntity familiaMentora = new FamiliaEntity();
            familiaMentora.setId(mentoriaDTO.getFamiliaMentoraId());
            mentoria.setFamiliaMentora(familiaMentora);
        }

        if (mentoriaDTO.getFamiliaMentoradaId() != null) {
            FamiliaEntity familiaMentorada = new FamiliaEntity();
            familiaMentorada.setId(mentoriaDTO.getFamiliaMentoradaId());
            mentoria.setFamiliaMentorada(familiaMentorada);
        }

        return mentoria;
    }

    public static void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, MentoriaEntity mentoria) {
        mentoria.setEstadoMentoria(mentoriaDTO.getEstadoMentoria());
        mentoria.setFechaAsignacion(mentoriaDTO.getFechaAsignacion());

        // Actualizar la relación con FamiliaEntity
        if (mentoriaDTO.getFamiliaMentoraId() != null) {
            FamiliaEntity familiaMentora = new FamiliaEntity();
            familiaMentora.setId(mentoriaDTO.getFamiliaMentoraId());
            mentoria.setFamiliaMentora(familiaMentora);
        }

        if (mentoriaDTO.getFamiliaMentoradaId() != null) {
            FamiliaEntity familiaMentorada = new FamiliaEntity();
            familiaMentorada.setId(mentoriaDTO.getFamiliaMentoradaId());
            mentoria.setFamiliaMentorada(familiaMentorada);
        }
    }
}