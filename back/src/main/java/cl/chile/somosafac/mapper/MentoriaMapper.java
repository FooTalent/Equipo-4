package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MentoriaMapper {
    MentoriaDTO toDto(MentoriaEntity mentoria);

    MentoriaEntity toEntity(MentoriaDTO mentoriaDTO);

    void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, @MappingTarget MentoriaEntity mentoria);
}
