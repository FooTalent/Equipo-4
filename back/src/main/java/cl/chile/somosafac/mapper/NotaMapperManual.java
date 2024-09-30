package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;

public class NotaMapper {
    public static NotaDTO notaToDto(NotaEntity notaEntity) {
        NotaDTO dto = new NotaDTO();
        dto.setId(notaEntity.getId());

        return null;
    }
}