package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.VoluntarioRepository;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoluntarioServiceTest {

    @Mock
    private VoluntarioRepository voluntarioRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private VoluntarioService voluntarioService;

    private VoluntarioEntity voluntarioEntity;
    private VoluntarioDTO voluntarioDTO;
    private UsuarioEntity usuarioEntity;

    @BeforeEach
    void setUp() {
        voluntarioEntity = new VoluntarioEntity();
        voluntarioEntity.setId(1L);
        voluntarioEntity.setOcupacion("Ocupación");
        voluntarioEntity.setEstadoVoluntario("Activo");

        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);
        voluntarioEntity.setUsuario(usuarioEntity);

        // Cambiar la forma en que se establece el usuario en el DTO
        voluntarioDTO = new VoluntarioDTO();
        voluntarioDTO.setId(1L);
        voluntarioDTO.setOcupacion("Ocupación");
        voluntarioDTO.setEstadoVoluntario("Activo");

        // Crear el mapa usuarioVoluntario
        Map<String, Object> usuarioVoluntario = new HashMap<>();
        usuarioVoluntario.put("id", 1L);
        voluntarioDTO.setUsuarioVoluntario(usuarioVoluntario);
    }

    @Test
    void getAllVoluntarios_retornaListaDeVoluntarios() {
        // Configurar el mock
        when(voluntarioRepository.findAll()).thenReturn(List.of(voluntarioEntity));

        // Llamar al método
        List<VoluntarioDTO> voluntarios = voluntarioService.getAllVoluntarios();

        // Verificar el resultado
        assertNotNull(voluntarios);
        assertEquals(1, voluntarios.size());
        assertEquals(voluntarioDTO.getId(), voluntarios.get(0).getId());
        assertEquals(voluntarioDTO.getOcupacion(), voluntarios.get(0).getOcupacion());
        assertEquals(voluntarioDTO.getEstadoVoluntario(), voluntarios.get(0).getEstadoVoluntario());
        // Ajusta según el nuevo DTO
        assertEquals(voluntarioDTO.getUsuarioVoluntario().get("id"), voluntarios.get(0).getUsuarioVoluntario().get("id"));
    }

    @Test
    void getVoluntario() {
        // Configurar el mock
        when(voluntarioRepository.findById(1L)).thenReturn(Optional.of(voluntarioEntity));

        // Llamar al método
        VoluntarioDTO voluntario = voluntarioService.getVoluntario(1L);

        // Verificar el resultado
        assertNotNull(voluntario);
        assertEquals(voluntarioDTO.getId(), voluntario.getId());
    }

    @Test
    void createVoluntario() {
        // Configurar el mock
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEntity));
        when(voluntarioRepository.save(any(VoluntarioEntity.class))).thenReturn(voluntarioEntity);

        // Llamar al método
        VoluntarioDTO voluntario = voluntarioService.createVoluntario(voluntarioDTO);

        // Verificar el resultado
        assertNotNull(voluntario);
        assertEquals(voluntarioDTO.getId(), voluntario.getId());
    }

    @Test
    void updateVoluntario() {
        // Configurar el mock
        when(voluntarioRepository.findById(1L)).thenReturn(Optional.of(voluntarioEntity));
        when(voluntarioRepository.save(any(VoluntarioEntity.class))).thenReturn(voluntarioEntity);

        // Llamar al método
        VoluntarioDTO voluntario = voluntarioService.updateVoluntario(1L, voluntarioDTO);

        // Verificar el resultado
        assertNotNull(voluntario);
        assertEquals(voluntarioDTO.getId(), voluntario.getId());
    }

    @Test
    void deleteVoluntario() {
        // Llamar al método
        voluntarioService.deleteVoluntario(1L);

        // Verificar el resultado
        verify(voluntarioRepository).deleteById(1L);
    }
}
