package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T10:51:25-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
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
