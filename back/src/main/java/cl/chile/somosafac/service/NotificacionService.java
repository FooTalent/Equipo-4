package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.mapper.NotificacionMapperManual;
import cl.chile.somosafac.repository.NotificacionRepository;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificacionService(NotificacionRepository notificacionRepository, UsuarioRepository usuarioRepository) {
        this.notificacionRepository = notificacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public NotificacionDTO getNotificacion(Long id) {
        NotificacionEntity notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        return NotificacionMapperManual.notificacionToDto(notificacion);
    }

    public List<NotificacionDTO> getAllNotificaciones() {
        List<NotificacionEntity> notificaciones = notificacionRepository.findAll();
        return notificaciones.stream()
                .map(NotificacionMapperManual::notificacionToDto)
                .collect(Collectors.toList());
    }

    public NotificacionDTO createNotificacion(NotificacionDTO notificacionDTO) {
        UsuarioEntity usuario = usuarioRepository.findById(notificacionDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        NotificacionEntity notificacion = NotificacionMapperManual.notificacionToEntity(notificacionDTO);
        notificacion.setUsuario(usuario);

        return NotificacionMapperManual.notificacionToDto(notificacionRepository.save(notificacion));
    }

    public NotificacionDTO updateNotificacion(Long id, NotificacionDTO notificacionDTO) {
        NotificacionEntity notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

        NotificacionMapperManual.updateNotificacionFromDto(notificacionDTO, notificacion);

        return NotificacionMapperManual.notificacionToDto(notificacionRepository.save(notificacion));
    }

    public void deleteNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }
}