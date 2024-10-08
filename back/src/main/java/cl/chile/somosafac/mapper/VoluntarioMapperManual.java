package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.entity.UsuarioEntity;

public class VoluntarioMapperManual {

    public static VoluntarioDTO voluntarioToDto(VoluntarioEntity voluntario) {
        VoluntarioDTO dto = new VoluntarioDTO();
        dto.setId(voluntario.getId());
        dto.setUsuarioId(voluntario.getUsuario().getId());
        dto.setOcupacion(voluntario.getOcupacion());
        dto.setEstadoVoluntario(voluntario.getEstadoVoluntario());
        return dto;
    }

    public static VoluntarioEntity voluntarioToEntity(VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntario = new VoluntarioEntity();
        voluntario.setOcupacion(voluntarioDTO.getOcupacion());
        voluntario.setEstadoVoluntario(voluntarioDTO.getEstadoVoluntario());

        // Establecer la relación con UsuarioEntity
        if (voluntarioDTO.getUsuarioId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(voluntarioDTO.getUsuarioId());
            voluntario.setUsuario(usuario);
        }

        return voluntario;
    }

    public static void updateVoluntarioFromDto(VoluntarioDTO voluntarioDTO, VoluntarioEntity voluntario) {
        voluntario.setOcupacion(voluntarioDTO.getOcupacion());
        voluntario.setEstadoVoluntario(voluntarioDTO.getEstadoVoluntario());

        // Actualizar la relación con UsuarioEntity
        if (voluntarioDTO.getUsuarioId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(voluntarioDTO.getUsuarioId());
            voluntario.setUsuario(usuario);
        }
    }
}