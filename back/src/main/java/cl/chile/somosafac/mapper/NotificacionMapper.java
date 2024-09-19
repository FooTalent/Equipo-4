package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificacionMapper {
    NotificacionDTO toDto(NotificacionEntity notificacion);

    NotificacionEntity toEntity(NotificacionDTO notificacionDTO);
}

