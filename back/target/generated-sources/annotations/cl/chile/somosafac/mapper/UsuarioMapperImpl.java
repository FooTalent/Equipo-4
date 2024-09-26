package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T23:10:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDto(UsuarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setCorreo( entity.getCorreo() );
        usuarioDTO.setContrasenaHash( entity.getContrasenaHash() );
        usuarioDTO.setTipoUsuario( entity.getTipoUsuario() );
        usuarioDTO.setActivo( entity.getActivo() );
        usuarioDTO.setVerificado( entity.getVerificado() );
        usuarioDTO.setFechaRegistro( entity.getFechaRegistro() );
        usuarioDTO.setFechaUltimoAcceso( entity.getFechaUltimoAcceso() );
        usuarioDTO.setAceptarTerminos( entity.getAceptarTerminos() );

        return usuarioDTO;
    }

    @Override
    public UsuarioEntity toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioEntity.UsuarioEntityBuilder usuarioEntity = UsuarioEntity.builder();

        usuarioEntity.id( dto.getId() );
        usuarioEntity.correo( dto.getCorreo() );
        usuarioEntity.contrasenaHash( dto.getContrasenaHash() );
        usuarioEntity.tipoUsuario( dto.getTipoUsuario() );
        usuarioEntity.fechaRegistro( dto.getFechaRegistro() );
        usuarioEntity.activo( dto.getActivo() );
        usuarioEntity.verificado( dto.getVerificado() );
        usuarioEntity.fechaUltimoAcceso( dto.getFechaUltimoAcceso() );
        usuarioEntity.aceptarTerminos( dto.getAceptarTerminos() );

        return usuarioEntity.build();
    }
}
