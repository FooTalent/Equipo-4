package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T17:30:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(UsuarioEntity usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        return usuarioDTO;
    }

    @Override
    public UsuarioEntity usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        return usuarioEntity;
    }
}
