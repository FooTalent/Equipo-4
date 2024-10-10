package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.ContactoDTO;
import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.ContactoEntity;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.repository.ContactoRepository;
import cl.chile.somosafac.repository.FamiliaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ContactoServiceTest {

    @Mock
    private ContactoRepository contactoRepository;

    @Mock
    private FamiliaRepository familiaRepository;

    @InjectMocks
    private ContactoService contactoService;

    private ContactoEntity contactoEntity;
    private ContactoDTO contactoDTO;
    private FamiliaEntity familiaEntity;

    @BeforeEach
    void setUp() {
        familiaEntity = new FamiliaEntity();
        familiaEntity.setId(1L);
        familiaEntity.setHistorialContacto(new ArrayList<>());

        contactoEntity = new ContactoEntity();
        contactoEntity.setId(1L);
        contactoEntity.setFechaContacto(LocalDateTime.now());
        contactoEntity.setFamilia(familiaEntity);

        contactoDTO = new ContactoDTO();
        contactoDTO.setId(1L);
        contactoDTO.setFechaContacto(LocalDateTime.now());
    }

    @Test
    void listarFamiliasConContacto() {
        // Configurar el mock
        familiaEntity.getHistorialContacto().add(contactoEntity);
        when(familiaRepository.findAll()).thenReturn(List.of(familiaEntity));

        // Llamar al método
        List<FamiliaDTO> familias = contactoService.listarFamiliasConContacto();

        // Verificar el resultado
        assertNotNull(familias);
        assertEquals(1, familias.size());
    }

    @Test
    void obtenerHistorialContactoFamilia() {
        // Configurar el mock
        familiaEntity.getHistorialContacto().add(contactoEntity);
        when(familiaRepository.findById(1L)).thenReturn(Optional.of(familiaEntity));

        // Llamar al método
        List<ContactoDTO> contactos = contactoService.obtenerHistorialContactoFamilia(1L);

        // Verificar el resultado
        assertNotNull(contactos);
        System.out.println("Tamaño de la lista: " + contactos.size());
        assertTrue(!contactos.isEmpty()); // Verifica que la lista no esté vacía
        assertEquals(contactoDTO.getId(), contactos.get(0).getId());
    }

    @Test
    void programarContacto() {
        // Configurar el mock
        when(familiaRepository.findById(any())).thenReturn(Optional.of(familiaEntity));
        when(contactoRepository.save(any(ContactoEntity.class))).thenReturn(contactoEntity);

        // Llamar al método
        contactoDTO.setId(1L);
        ContactoDTO contacto = contactoService.programarContacto(contactoDTO);

        // Verificar el resultado
        assertNotNull(contacto);
        assertEquals(contactoDTO.getId(), contacto.getId());
    }

    @Test
    void actualizarContacto() {
        // Configurar el mock
        when(contactoRepository.findById(1L)).thenReturn(Optional.of(contactoEntity));
        when(contactoRepository.save(any(ContactoEntity.class))).thenReturn(contactoEntity);

        // Llamar al método
        ContactoDTO contacto = contactoService.actualizarContacto(1L, contactoDTO);

        // Verificar el resultado
        assertNotNull(contacto);
        assertEquals(contactoDTO.getId(), contacto.getId());
    }

    @Test
    void eliminarContacto() {
        // Configurar el mock
        when(contactoRepository.findById(1L)).thenReturn(Optional.of(contactoEntity));

        // Llamar al método
        contactoService.eliminarContacto(1L);

        // Verificar el resultado
        verify(contactoRepository).deleteById(1L);
    }
}