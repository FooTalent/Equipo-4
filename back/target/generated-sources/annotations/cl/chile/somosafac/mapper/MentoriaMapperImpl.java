package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T17:30:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class MentoriaMapperImpl implements MentoriaMapper {

    @Override
    public MentoriaDTO toDto(MentoriaEntity mentoria) {
        if ( mentoria == null ) {
            return null;
        }

        MentoriaDTO mentoriaDTO = new MentoriaDTO();

        return mentoriaDTO;
    }

    @Override
    public MentoriaEntity toEntity(MentoriaDTO mentoriaDTO) {
        if ( mentoriaDTO == null ) {
            return null;
        }

        MentoriaEntity mentoriaEntity = new MentoriaEntity();

        return mentoriaEntity;
    }

    @Override
    public void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, MentoriaEntity mentoria) {
        if ( mentoriaDTO == null ) {
            return;
        }
    }
}
