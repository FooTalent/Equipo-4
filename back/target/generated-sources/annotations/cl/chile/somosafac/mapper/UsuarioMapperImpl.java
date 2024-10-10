package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T23:37:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDto(UsuarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        return usuarioDTO;
    }

    @Override
    public UsuarioEntity toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        return usuarioEntity;
    }
}
