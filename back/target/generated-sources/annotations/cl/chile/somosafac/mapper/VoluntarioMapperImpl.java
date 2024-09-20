package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T01:29:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class VoluntarioMapperImpl implements VoluntarioMapper {

    @Override
    public VoluntarioDTO toDto(VoluntarioEntity voluntario) {
        if ( voluntario == null ) {
            return null;
        }

        VoluntarioDTO voluntarioDTO = new VoluntarioDTO();

        return voluntarioDTO;
    }

    @Override
    public VoluntarioEntity toEntity(VoluntarioDTO voluntarioDTO) {
        if ( voluntarioDTO == null ) {
            return null;
        }

        VoluntarioEntity voluntarioEntity = new VoluntarioEntity();

        return voluntarioEntity;
    }
}
