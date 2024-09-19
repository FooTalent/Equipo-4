package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaMapper {
    NotaDTO toDto(NotaEntity nota);

    NotaEntity toEntity(NotaDTO notaDTO);
}
