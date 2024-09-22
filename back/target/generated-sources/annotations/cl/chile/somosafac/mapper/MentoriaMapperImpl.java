package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-22T15:32:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MentoriaMapperImpl implements MentoriaMapper {

    @Override
    public MentoriaDTO mentoriaToDto(MentoriaEntity mentoria) {
        if ( mentoria == null ) {
            return null;
        }

        MentoriaDTO mentoriaDTO = new MentoriaDTO();

        mentoriaDTO.setId( mentoria.getId() );
        mentoriaDTO.setFechaAsignacion( mentoria.getFechaAsignacion() );
        mentoriaDTO.setEstadoMentoria( mentoria.getEstadoMentoria() );

        return mentoriaDTO;
    }

    @Override
    public MentoriaEntity mentoriaToEntity(MentoriaDTO mentoriaDTO) {
        if ( mentoriaDTO == null ) {
            return null;
        }

        MentoriaEntity mentoriaEntity = new MentoriaEntity();

        mentoriaEntity.setId( mentoriaDTO.getId() );
        mentoriaEntity.setFechaAsignacion( mentoriaDTO.getFechaAsignacion() );
        mentoriaEntity.setEstadoMentoria( mentoriaDTO.getEstadoMentoria() );

        return mentoriaEntity;
    }

    @Override
    public void updateMentoriaFromDto(MentoriaDTO mentoriaDTO, MentoriaEntity mentoria) {
        if ( mentoriaDTO == null ) {
            return;
        }

        mentoria.setId( mentoriaDTO.getId() );
        mentoria.setFechaAsignacion( mentoriaDTO.getFechaAsignacion() );
        mentoria.setEstadoMentoria( mentoriaDTO.getEstadoMentoria() );
    }
}
