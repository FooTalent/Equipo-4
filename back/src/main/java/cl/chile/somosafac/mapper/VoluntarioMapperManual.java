package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.entity.UsuarioEntity;

import java.util.HashMap;
import java.util.Map;

public class VoluntarioMapperManual {

    public static VoluntarioDTO voluntarioToDto(VoluntarioEntity voluntario) {
        VoluntarioDTO dto = new VoluntarioDTO();

        Map<String, Object> usuarioVoluntario = new HashMap<>();
        usuarioVoluntario.put("id", voluntario.getId());
        usuarioVoluntario.put("nombre", voluntario.getUsuario().getNombre());
        dto.setUsuarioVoluntario(usuarioVoluntario);

        dto.setId(voluntario.getId());
        dto.setOcupacion(voluntario.getOcupacion());
        dto.setEstadoVoluntario(voluntario.getEstadoVoluntario());
        return dto;
    }

    public static VoluntarioEntity voluntarioToEntity(VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntario = new VoluntarioEntity();
        voluntario.setOcupacion(voluntarioDTO.getOcupacion());
        voluntario.setEstadoVoluntario(voluntarioDTO.getEstadoVoluntario());

        if(voluntarioDTO.getUsuarioVoluntario() != null && voluntarioDTO.getId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId((Long) voluntarioDTO.getUsuarioVoluntario().get("id"));
            voluntario.setUsuario(usuario);
        }

        return voluntario;
    }

    public static void updateVoluntarioFromDto(VoluntarioDTO voluntarioDTO, VoluntarioEntity voluntario) {
        voluntario.setOcupacion(voluntarioDTO.getOcupacion());
        voluntario.setEstadoVoluntario(voluntarioDTO.getEstadoVoluntario());

        if(voluntarioDTO.getUsuarioVoluntario() != null && voluntarioDTO.getId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId((Long) voluntarioDTO.getUsuarioVoluntario().get("id"));
            voluntario.setUsuario(usuario);
        }
    }
}