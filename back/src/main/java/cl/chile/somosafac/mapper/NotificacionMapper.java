package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacionMapper {

    NotificacionMapper INSTANCE = Mappers.getMapper(NotificacionMapper.class);

    NotificacionDTO notificacionToDto(NotificacionEntity notificacion);

    NotificacionEntity notificacionToEntity(NotificacionDTO notificacionDTO);

    void updateNotificacionFromDto(NotificacionDTO notificacionDTO, @MappingTarget NotificacionEntity notificacion);
}