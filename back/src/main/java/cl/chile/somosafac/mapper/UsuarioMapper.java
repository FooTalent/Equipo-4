package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {



    UsuarioDTO usuarioToUsuarioDTO(UsuarioEntity usuario);


    UsuarioEntity usuarioDTOToUsuario(UsuarioDTO usuarioDTO);


}
