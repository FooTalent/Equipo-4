package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UsuarioEntity usuarioEntity;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);
        usuarioEntity.setCorreo("correo@example.com");
        usuarioEntity.setContrasenaHash("contrasena");
        usuarioEntity.setTipoUsuario(cl.chile.somosafac.security.Role.ADMIN);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setCorreo("correo@example.com");
        usuarioDTO.setContrasenaHash("contrasena");
        usuarioDTO.setTipoUsuario(cl.chile.somosafac.security.Role.ADMIN);
    }

    @Test
    void obtenerTodos() {
        // Configurar el mock
        when(usuarioRepository.findAll()).thenReturn(List.of(usuarioEntity));

        // Llamar al método
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodos();

        // Verificar el resultado
        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
        assertEquals(usuarioDTO.getCorreo(), usuarios.get(0).getCorreo());
    }

    @Test
    void obtenerPorId() {
        // Configurar el mock
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEntity));

        // Llamar al método
        UsuarioDTO usuario = usuarioService.obtenerPorId(1L);

        // Verificar el resultado
        assertNotNull(usuario);
        assertEquals(usuarioDTO.getCorreo(), usuario.getCorreo());
    }


//    @Test
//    void actualizarUsuario() {
//        // Configurar el mock
//        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEntity));
//        when(usuarioRepository.save(any(UsuarioEntity.class))).thenReturn(usuarioEntity);
//
//        // Llamar al método
//        UsuarioDTO usuario = usuarioService.actualizarUsuario(1L, usuarioDTO);
//
//        // Verificar el resultado
//        assertNotNull(usuario);
//        assertEquals(usuarioDTO.getCorreo(), usuario.getCorreo());
//    }

    @Test
    void eliminarUsuario() {
        // Configurar el mock
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEntity));

        // Llamar al método
        usuarioService.eliminarUsuario(1L);

        // Verificar el resultado
        // Verificar que se llamó al método deleteById del repositorio
    }
}