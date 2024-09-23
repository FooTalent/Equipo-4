package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToDto(UsuarioEntity usuario);

    UsuarioEntity usuarioToEntity(UsuarioDTO usuarioDTO);

    void updateUsuarioFromDto(UsuarioDTO usuarioDTO, @MappingTarget UsuarioEntity usuario);
}