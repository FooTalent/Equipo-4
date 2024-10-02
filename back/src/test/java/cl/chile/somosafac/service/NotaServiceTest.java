package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.NotaEntity;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.repository.NotaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotaServiceTest {

    @Mock
    private NotaRepository notaRepository;

    @InjectMocks
    private NotaService notaService;

    private NotaEntity notaEntity;
    private NotaDTO notaDTO;
    private FamiliaEntity familiaEntity;
    private VoluntarioEntity voluntarioEntity;

    @BeforeEach
    void setUp() {
        notaEntity = new NotaEntity();
        notaEntity.setId(1L);
        notaEntity.setDescripcion("Nota 1");

        familiaEntity = new FamiliaEntity();
        familiaEntity.setId(1L);
        notaEntity.setFamilia(familiaEntity);

        voluntarioEntity = new VoluntarioEntity();
        voluntarioEntity.setId(1L);
        notaEntity.setVoluntario(voluntarioEntity);

        notaDTO = new NotaDTO();
        notaDTO.setId(1L);
        notaDTO.setDescripcion("Nota 1");
    }

    @Test
    void getNotas() {
        // Configurar el mock
        when(notaRepository.findAll()).thenReturn(List.of(notaEntity));

        // Llamar al método
        List<NotaDTO> notas = notaService.getNotas();

        // Verificar el resultado
        assertNotNull(notas);
        assertEquals(1, notas.size());
        assertEquals(notaDTO.getId(), notas.get(0).getId());
    }

    @Test
    void getNota() {
        // Configurar el mock
        when(notaRepository.findById(1L)).thenReturn(Optional.of(notaEntity));

        // Llamar al método
        NotaDTO nota = notaService.getNota(1L);

        // Verificar el resultado
        assertNotNull(nota);
        assertEquals(notaDTO.getId(), nota.getId());
    }

    @Test
    void createNota() {
        // Configurar el mock
        when(notaRepository.save(any(NotaEntity.class))).thenReturn(notaEntity);

        // Llamar al método
        NotaDTO nota = notaService.createNota(notaDTO, familiaEntity, voluntarioEntity);

        // Verificar el resultado
        assertNotNull(nota);
        assertEquals(notaDTO.getId(), nota.getId());
    }

    @Test
    void updateNota() {
        // Configurar el mock
        when(notaRepository.findById(1L)).thenReturn(Optional.of(notaEntity));
        when(notaRepository.save(any(NotaEntity.class))).thenReturn(notaEntity);

        // Llamar al método
        NotaDTO nota = notaService.updateNota(1L, notaDTO, familiaEntity, voluntarioEntity);

        // Verificar el resultado
        assertNotNull(nota);
        assertEquals(notaDTO.getId(), nota.getId());
    }

    @Test
    void deleteNota() {
        // Configurar el mock
        when(notaRepository.findById(1L)).thenReturn(Optional.of(notaEntity));

        // Llamar al método
        notaService.deleteNota(1L);

        // Verificar el resultado
        verify(notaRepository).deleteById(1L);
    }
}