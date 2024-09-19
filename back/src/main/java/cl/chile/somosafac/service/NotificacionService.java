package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.mapper.NotificacionMapper;
import cl.chile.somosafac.repository.NotificacionRepository;
import org.springframework.stereotype.Service;


@Service
public class NotificacionService {
    private final NotificacionRepository notificacionRepository;
    private final NotificacionMapper notificacionMapper;

    public NotificacionService(NotificacionRepository notificacionRepository, NotificacionMapper notificacionMapper) {
        this.notificacionRepository = notificacionRepository;
        this.notificacionMapper = notificacionMapper;
    }

    public NotificacionDTO getNotificacion(Long id) {
        NotificacionEntity notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificacion not found"));
        return notificacionMapper.toDto(notificacion);
    }

    public NotificacionEntity createNotificacion(NotificacionDTO notificacionDTO) {
        NotificacionEntity notificacion = notificacionMapper.toEntity(notificacionDTO);
        return notificacionRepository.save(notificacion);
    }

    public NotificacionDTO updateNotificacion(Long id, NotificacionDTO notificacionDTO) {
        NotificacionEntity notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificacion not found"));
        notificacionMapper.toEntity(notificacionDTO);
        return notificacionMapper.toDto(notificacionRepository.save(notificacion));
    }

    public void deleteNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }
}


