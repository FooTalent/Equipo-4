package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MentoriaMapper {

    MentoriaMapper INSTANCE = Mappers.getMapper(MentoriaMapper.class);

    MentoriaDTO mentoriaToDto(MentoriaEntity mentoria);

    MentoriaEntity mentoriaToEntity(MentoriaDTO mentoriaDTO);

    void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, @MappingTarget MentoriaEntity mentoria);
}