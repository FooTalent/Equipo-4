package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.NotificacionRepository;
import cl.chile.somosafac.repository.UsuarioRepository;
import cl.chile.somosafac.service.NotificacionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NotificacionServiceTest {

    @Mock
    private NotificacionRepository notificacionRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private NotificacionService notificacionService;

    private NotificacionEntity notificacionEntity;
    private NotificacionDTO notificacionDTO;
    private UsuarioEntity usuarioEntity;

    @Before
    public void setUp() {
        notificacionEntity = new NotificacionEntity();
        notificacionEntity.setId(1L);
        notificacionEntity.setMensaje("Hola, mundo!");

        notificacionDTO = new NotificacionDTO();
        notificacionDTO.setId(1L);
        notificacionDTO.setMensaje("Hola, mundo!");
        notificacionDTO.setUsuarioId(1L);

        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);
        usuarioEntity.setCorreo("example@example.com");

        when(notificacionRepository.findById(1L)).thenReturn(Optional.of(notificacionEntity));
        when(notificacionRepository.save(any(NotificacionEntity.class))).thenReturn(notificacionEntity);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEntity));
        when(notificacionRepository.findAll()).thenReturn(List.of(notificacionEntity));
    }

    @Test
    public void testGetNotificacion() {
        NotificacionDTO notificacionObtenida = notificacionService.getNotificacion(1L);

        assertEquals(notificacionDTO.getId(), notificacionObtenida.getId());
        assertEquals(notificacionDTO.getMensaje(), notificacionObtenida.getMensaje());
    }

    @Test
    public void testGetAllNotificaciones() {
        List<NotificacionDTO> notificacionesObtenidas = notificacionService.getAllNotificaciones();

        assertEquals(1, notificacionesObtenidas.size());
        assertEquals(notificacionDTO.getId(), notificacionesObtenidas.get(0).getId());
        assertEquals(notificacionDTO.getMensaje(), notificacionesObtenidas.get(0).getMensaje());
    }

    @Test
    public void testCreateNotificacion() {
        NotificacionDTO notificacionCreada = notificacionService.createNotificacion(notificacionDTO);

        assertEquals(notificacionDTO.getId(), notificacionCreada.getId());
        assertEquals(notificacionDTO.getMensaje(), notificacionCreada.getMensaje());
        verify(notificacionRepository, times(1)).save(any(NotificacionEntity.class));
    }

    @Test
    public void testUpdateNotificacion() {
        NotificacionDTO notificacionActualizada = notificacionService.updateNotificacion(1L, notificacionDTO);

        assertEquals(notificacionDTO.getId(), notificacionActualizada.getId());
        assertEquals(notificacionDTO.getMensaje(), notificacionActualizada.getMensaje());
        verify(notificacionRepository, times(1)).save(any(NotificacionEntity.class));
    }

    @Test
    public void testDeleteNotificacion() {
        notificacionService.deleteNotificacion(1L);

        verify(notificacionRepository, times(1)).deleteById(1L);
    }
}