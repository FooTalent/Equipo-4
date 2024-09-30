package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T23:07:04-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public NotificacionDTO notificacionToDto(NotificacionEntity notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        NotificacionDTO notificacionDTO = new NotificacionDTO();

        return notificacionDTO;
    }

    @Override
    public NotificacionEntity notificacionToEntity(NotificacionDTO notificacionDTO) {
        if ( notificacionDTO == null ) {
            return null;
        }

        NotificacionEntity notificacionEntity = new NotificacionEntity();

        return notificacionEntity;
    }

    @Override
    public void updateNotificacionFromDto(NotificacionDTO notificacionDTO, NotificacionEntity notificacion) {
        if ( notificacionDTO == null ) {
            return;
        }
    }
}
