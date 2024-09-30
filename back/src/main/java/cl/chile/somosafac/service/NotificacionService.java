package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.mapper.NotificacionMapper;
import cl.chile.somosafac.repository.NotificacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final NotificacionMapper notificacionMapper;

    public NotificacionService(NotificacionRepository notificacionRepository, NotificacionMapper notificacionMapper) {
        this.notificacionRepository = notificacionRepository;
        this.notificacionMapper = notificacionMapper;
    }

    @Transactional(readOnly = true)
    public List<NotificacionDTO> getNotificaciones() {
        List<NotificacionEntity> notificaciones = notificacionRepository.findAll();
        return notificaciones.stream()
                .map(notificacionMapper::notificacionToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NotificacionDTO getNotificacion(Long id) {
        Optional<NotificacionEntity> notificacion = notificacionRepository.findById(id);
        return notificacion.map(notificacionMapper::notificacionToDto).orElse(null);
    }

    @Transactional
    public NotificacionDTO createNotificacion(NotificacionDTO notificacionDTO) {
        NotificacionEntity notificacion = notificacionMapper.notificacionToEntity(notificacionDTO);
        NotificacionEntity nuevaNotificacion = notificacionRepository.save(notificacion);
        return notificacionMapper.notificacionToDto(nuevaNotificacion);
    }

    @Transactional
    public NotificacionDTO updateNotificacion(Long id, NotificacionDTO notificacionDTO) {
        Optional<NotificacionEntity> notificacionExistente = notificacionRepository.findById(id);
        if (notificacionExistente.isPresent()) {
            NotificacionEntity notificacion = notificacionExistente.get();
            notificacionMapper.updateNotificacionFromDto(notificacionDTO, notificacion);
            NotificacionEntity notificacionActualizada = notificacionRepository.save(notificacion);
            return notificacionMapper.notificacionToDto(notificacionActualizada);
        }
        return null; // Manejar el caso donde no se encuentra la notificación
    }

    @Transactional
    public void deleteNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }
}