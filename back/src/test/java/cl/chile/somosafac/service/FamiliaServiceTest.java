package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.repository.FamiliaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para el servicio FamiliaService.
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since [Fecha]
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FamiliaServiceTest {

    /**
     * Repositorio de Familia mockeado.
     */
    @Mock
    private FamiliaRepository familiaRepository;

    /**
     * Servicio FamiliaService con dependencias injectadas.
     */
    @InjectMocks
    private FamiliaService familiaService;

    /**
     * Prueba obtener todas las familias.
     *
     * @throws Exception si no se pueden obtener las familias
     */
    @Test
    public void testGetFamilias() {
        // Arrange: Configurar el mock para retornar una lista de familias
        List<FamiliaEntity> familias = List.of(new FamiliaEntity(), new FamiliaEntity());
        when(familiaRepository.findAll()).thenReturn(familias);

        // Act: Llamar al método getFamilias del servicio
        List<FamiliaDTO> resultado = familiaService.getFamilias();

        // Assert: Verificar que se retornen las familias esperadas
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    /**
     * Prueba obtener familia existente por ID.
     *
     * @throws Exception si no se encuentra la familia
     */
    @Test
    public void testGetFamiliaExistente() {
        // Arrange: Configurar el mock para retornar una familia existente
        FamiliaEntity familia = new FamiliaEntity();
        familia.setId(1L);
        when(familiaRepository.findById(1L)).thenReturn(Optional.of(familia));

        // Act: Llamar al método getFamilia del servicio
        FamiliaDTO resultado = familiaService.getFamilia(1L);

        // Assert: Verificar que se retorne la familia esperada
        assertNotNull(resultado);
        assertEquals(familia.getId(), resultado.getId());
    }

    /**
     * Prueba obtener familia no existente por ID.
     */
    @Test
    public void testGetFamiliaNoExistente() {
        // Arrange: Configurar el mock para retornar una familia no existente
        when(familiaRepository.findById(1L)).thenReturn(Optional.empty());

        // Act: Llamar al método getFamilia del servicio
        FamiliaDTO resultado = familiaService.getFamilia(1L);

        // Assert: Verificar que se retorne null
        assertNull(resultado);
    }

    /**
     * Prueba crear familia.
     *
     * @throws Exception si no se puede crear la familia
     */
    @Test
    public void testCreateFamilia() {
        // Arrange: Configurar el mock para retornar la familia creada
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setId(1L);
        FamiliaEntity familia = new FamiliaEntity();
        familia.setId(1L);
        when(familiaRepository.save(any(FamiliaEntity.class))).thenReturn(familia);

        // Act: Llamar al método createFamilia del servicio
        FamiliaDTO resultado = familiaService.createFamilia(familiaDTO);

        // Assert: Verificar que se retorne la familia creada
        assertNotNull(resultado);
        assertEquals(familiaDTO.getId(), resultado.getId());
    }

    /**
     * Prueba actualizar familia existente.
     *
     * @throws Exception si no se encuentra la familia
     */
    @Test
    public void testUpdateFamiliaExistente() {
        // Arrange: Configurar el mock para retornar la familia actualizada
        FamiliaEntity familiaExistente = new FamiliaEntity();
        familiaExistente.setId(1L);
        when(familiaRepository.findById(1L)).thenReturn(Optional.of(familiaExistente));
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setId(1L);

        // Configurar el mock para retornar la familia actualizada
        FamiliaEntity familiaActualizada = new FamiliaEntity();
        familiaActualizada.setId(1L);
        when(familiaRepository.save(any(FamiliaEntity.class))).thenReturn(familiaActualizada);

        // Act: Llamar al método updateFamilia del servicio
        Optional<FamiliaDTO> resultado = familiaService.updateFamilia(1L, familiaDTO);

        // Assert: Verificar que se retorne la familia actualizada
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(familiaDTO.getId(), resultado.get().getId());
    }

    /**
     * Prueba actualizar familia no existente.
     */
    @Test
    public void testUpdateFamiliaNoExistente() {
        // Arrange: Configurar el mock para retornar una familia no existente
        when(familiaRepository.findById(1L)).thenReturn(Optional.empty());
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setId(1L);

        // Act: Llamar al método updateFamilia del servicio
        Optional<FamiliaDTO> resultado = familiaService.updateFamilia(1L, familiaDTO);

        // Assert: Verificar que se retorne null
        assertFalse(resultado.isPresent());
    }

    /**
     * Prueba eliminar familia existente.
     *
     * @throws Exception si no se encuentra la familia
     */
    @Test
    public void testDeleteFamiliaExistente() {
        // Arrange: Configurar el mock para retornar la familia existente
        FamiliaEntity familiaExistente = new FamiliaEntity();
        familiaExistente.setId(1L);
        when(familiaRepository.findById(1L)).thenReturn(Optional.of(familiaExistente));

        // Act: Llamar al método deleteFamilia del servicio
        familiaService.deleteFamilia(1L);

        // Assert: Verificar que se eliminó la familia
        verify(familiaRepository, times(1)).deleteById(1L);
    }

    /**
     * Prueba eliminar familia no existente.
     */
    @Test
    public void testDeleteFamiliaNoExistente() {
        // Arrange: Configurar el mock para retornar un Optional vacío
        when(familiaRepository.findById(1L)).thenReturn(Optional.empty());

        // Act y Assert: Verificar que se lance la excepción
        assertThrows(RuntimeException.class, () -> familiaService.deleteFamilia(1L));
        verify(familiaRepository, never()).deleteById(1L);
    }
}