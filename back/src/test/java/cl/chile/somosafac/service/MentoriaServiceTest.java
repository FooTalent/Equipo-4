package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.repository.MentoriaRepository;
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
class MentoriaServiceTest {

    @Mock
    private MentoriaRepository mentoriaRepository;

    @InjectMocks
    private MentoriaService mentoriaService;

    private MentoriaEntity mentoriaEntity;
    private MentoriaDTO mentoriaDTO;

    @BeforeEach
    void setUp() {
        mentoriaEntity = new MentoriaEntity();
        mentoriaEntity.setId(1L);
        mentoriaEntity.setEstadoMentoria("Pendiente");

        FamiliaEntity familiaMentora = new FamiliaEntity();
        familiaMentora.setId(1L);
        mentoriaEntity.setFamiliaMentora(familiaMentora);

        mentoriaDTO = new MentoriaDTO();
        mentoriaDTO.setId(1L);
        mentoriaDTO.setEstadoMentoria("Pendiente");
    }

    @Test
    void getMentorias() {
        // Configurar el mock
        when(mentoriaRepository.findAll()).thenReturn(List.of(mentoriaEntity));

        // Llamar al método
        List<MentoriaDTO> mentorias = mentoriaService.getMentorias();

        // Verificar el resultado
        assertNotNull(mentorias);
        assertEquals(1, mentorias.size());
        assertEquals(mentoriaDTO.getId(), mentorias.get(0).getId());
    }

    @Test
    void getMentoria() {
        // Configurar el mock
        when(mentoriaRepository.findById(1L)).thenReturn(Optional.of(mentoriaEntity));

        // Llamar al método
        MentoriaDTO mentoria = mentoriaService.getMentoria(1L);

        // Verificar el resultado
        assertNotNull(mentoria);
        assertEquals(mentoriaDTO.getId(), mentoria.getId());
    }

    @Test
    void createMentoria() {
        // Configurar el mock
        when(mentoriaRepository.save(any(MentoriaEntity.class))).thenReturn(mentoriaEntity);

        // Llamar al método
        MentoriaDTO mentoria = mentoriaService.createMentoria(mentoriaDTO);

        // Verificar el resultado
        assertNotNull(mentoria);
        assertEquals(mentoriaDTO.getId(), mentoria.getId());
    }

    @Test
    void updateMentoria() {
        // Configurar el mock
        when(mentoriaRepository.findById(1L)).thenReturn(Optional.of(mentoriaEntity));
        when(mentoriaRepository.save(any(MentoriaEntity.class))).thenReturn(mentoriaEntity);

        // Llamar al método
        Optional<MentoriaDTO> mentoriaOptional = mentoriaService.updateMentoria(1L, mentoriaDTO);

        // Verificar el resultado
        assertTrue(mentoriaOptional.isPresent());
        assertNotNull(mentoriaOptional.get());
        assertEquals(mentoriaDTO.getId(), mentoriaOptional.get().getId());
    }

    @Test
    void deleteMentoria() {
        // Configurar el mock
        when(mentoriaRepository.findById(1L)).thenReturn(Optional.of(mentoriaEntity));

        // Llamar al método
        mentoriaService.deleteMentoria(1L);

        // Verificar el resultado
        verify(mentoriaRepository).deleteById(1L);
    }
}