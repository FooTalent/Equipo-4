package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.NotaEntity;
import cl.chile.somosafac.entity.VoluntarioEntity;

public class NotaMapperManual {
    public static NotaDTO notaToDto(NotaEntity notaEntity) {
        NotaDTO dto = new NotaDTO();
        dto.setId(notaEntity.getId());
        dto.setFamiliaId(notaEntity.getFamilia().getId());
        dto.setVoluntarioId(notaEntity.getVoluntario().getId());
        dto.setDescripcion(notaEntity.getDescripcion());
        dto.setFechaCreacion(notaEntity.getFechaCreacion());
        return dto;
    }

    public static NotaEntity notaToEntity(NotaDTO notaDTO, FamiliaEntity familia, VoluntarioEntity voluntario) {
        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setId(notaDTO.getId());
        notaEntity.setFamilia(familia);
        notaEntity.setVoluntario(voluntario);
        notaEntity.setDescripcion(notaDTO.getDescripcion());
        return notaEntity;
    }
}
