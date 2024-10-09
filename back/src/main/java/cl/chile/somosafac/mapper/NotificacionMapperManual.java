package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.entity.UsuarioEntity;

public class NotificacionMapperManual {

    public static NotificacionDTO notificacionToDto(NotificacionEntity notificacion) {
        if (notificacion == null) {
            throw new NullPointerException("NotificacionEntity es nulo");
        }

        NotificacionDTO dto = new NotificacionDTO();
        dto.setId(notificacion.getId());
        dto.setMensaje(notificacion.getMensaje());
        dto.setFechaEnvio(notificacion.getFechaEnvio());
        dto.setTipoNotificacion(notificacion.getTipoNotificacion());

        if (notificacion.getUsuario() != null) {
            dto.setUsuarioId(notificacion.getUsuario().getId());
        }

        return dto;
    }

    public static NotificacionEntity notificacionToEntity(NotificacionDTO notificacionDTO) {
        if (notificacionDTO == null) {
            throw new NullPointerException("NotificacionDTO es nulo");
        }

        NotificacionEntity notificacion = new NotificacionEntity();
        notificacion.setId(notificacionDTO.getId());
        notificacion.setMensaje(notificacionDTO.getMensaje());
        notificacion.setFechaEnvio(notificacionDTO.getFechaEnvio());
        notificacion.setTipoNotificacion(notificacionDTO.getTipoNotificacion());

        if (notificacionDTO.getUsuarioId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(notificacionDTO.getUsuarioId());
            notificacion.setUsuario(usuario);
        }

        return notificacion;
    }

    public static void updateNotificacionFromDto(NotificacionDTO notificacionDTO, NotificacionEntity notificacion) {
        if (notificacionDTO == null || notificacion == null) {
            throw new NullPointerException("NotificacionDTO o NotificacionEntity es nulo");
        }

        notificacion.setMensaje(notificacionDTO.getMensaje());
        notificacion.setFechaEnvio(notificacionDTO.getFechaEnvio());
        notificacion.setTipoNotificacion(notificacionDTO.getTipoNotificacion());

        if (notificacionDTO.getUsuarioId() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(notificacionDTO.getUsuarioId());
            notificacion.setUsuario(usuario);
        }
    }
}