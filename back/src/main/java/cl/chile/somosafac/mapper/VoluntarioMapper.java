package cl.chile.somosafac.mapper;
import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VoluntarioMapper {

    VoluntarioMapper INSTANCE = Mappers.getMapper(VoluntarioMapper.class);

    VoluntarioDTO toDto(VoluntarioEntity voluntario);

    VoluntarioEntity toEntity(VoluntarioDTO voluntarioDTO);

}
