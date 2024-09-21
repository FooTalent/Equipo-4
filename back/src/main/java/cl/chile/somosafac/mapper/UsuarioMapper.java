package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "correo", target = "correo")
    })
    UsuarioDTO usuarioToUsuarioDTO(UsuarioEntity usuario);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "correo", target = "correo")
    })
    UsuarioEntity usuarioDTOToUsuario(UsuarioDTO usuarioDTO);


}
