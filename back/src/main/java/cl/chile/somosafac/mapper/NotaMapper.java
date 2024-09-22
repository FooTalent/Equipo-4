package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    NotaDTO notaToDto(NotaEntity nota);

    NotaEntity notaToEntity(NotaDTO notaDTO);

    void updateNotaFromDto(NotaDTO notaDTO, @MappingTarget NotaEntity nota);
}