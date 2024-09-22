package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FamiliaMapper {

    FamiliaMapper INSTANCE = Mappers.getMapper(FamiliaMapper.class);

    FamiliaDTO familiaToDto(FamiliaEntity familia);

    FamiliaEntity familiaToEntity(FamiliaDTO familiaDTO);

    FamiliaDTO familiatoDto(FamiliaEntity familia);

    FamiliaEntity familiatoEntity(FamiliaDTO familiaDTO);

    void updateFamiliaFromDto(FamiliaDTO familiaDTO, @MappingTarget FamiliaEntity familia);
}