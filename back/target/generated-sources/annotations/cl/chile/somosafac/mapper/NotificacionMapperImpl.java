package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-22T15:09:20-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public NotificacionDTO notificacionToDto(NotificacionEntity notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        NotificacionDTO notificacionDTO = new NotificacionDTO();

        notificacionDTO.setId( notificacion.getId() );
        notificacionDTO.setMensaje( notificacion.getMensaje() );
        notificacionDTO.setFechaEnvio( notificacion.getFechaEnvio() );
        notificacionDTO.setTipoNotificacion( notificacion.getTipoNotificacion() );

        return notificacionDTO;
    }

    @Override
    public NotificacionEntity notificacionToEntity(NotificacionDTO notificacionDTO) {
        if ( notificacionDTO == null ) {
            return null;
        }

        NotificacionEntity notificacionEntity = new NotificacionEntity();

        notificacionEntity.setId( notificacionDTO.getId() );
        notificacionEntity.setMensaje( notificacionDTO.getMensaje() );
        notificacionEntity.setFechaEnvio( notificacionDTO.getFechaEnvio() );
        notificacionEntity.setTipoNotificacion( notificacionDTO.getTipoNotificacion() );

        return notificacionEntity;
    }

    @Override
    public void updateNotificacionFromDto(NotificacionDTO notificacionDTO, NotificacionEntity notificacion) {
        if ( notificacionDTO == null ) {
            return;
        }

        notificacion.setId( notificacionDTO.getId() );
        notificacion.setMensaje( notificacionDTO.getMensaje() );
        notificacion.setFechaEnvio( notificacionDTO.getFechaEnvio() );
        notificacion.setTipoNotificacion( notificacionDTO.getTipoNotificacion() );
    }
}
