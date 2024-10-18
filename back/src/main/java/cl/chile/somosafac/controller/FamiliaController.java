package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.service.FamiliaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/familias")
@Tag(name = "Familia", description = "Listado de operaciones de la entidad Familia")
public class FamiliaController {
    private final FamiliaService familiaService;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @Operation(summary = "Obtener todas las familias", description = "Obtiene todas las familias registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Familias obtenidas exitosamente")
    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> obtenerTodas() {
        List<FamiliaDTO> familias = familiaService.getFamilias();
        return ResponseEntity.ok(familias);
    }

    @Operation(summary = "Obtener familia por ID", description = "Obtiene una familia específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Familia encontrada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Familia no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FamiliaDTO> obtenerPorId(@PathVariable Long id) {
        FamiliaDTO familia = familiaService.getFamilia(id);
        return familia != null ? ResponseEntity.ok(familia) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear una nueva familia", description = "Crea una nueva familia en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Familia creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<FamiliaDTO> crearFamilia(@RequestBody @Valid FamiliaDTO familiaDTO) {
        FamiliaDTO nuevaFamilia = familiaService.createFamilia(familiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFamilia);
    }

    @Operation(summary = "Buscar familias", description = "Busca familias por nombre, ciudad y región")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Familias encontradas exitosamente"),
            @ApiResponse(responseCode = "404", description = "Familias no encontradas")
    })
    @PostMapping("/buscar")
    public List<FamiliaDTO> searchFamilias(@RequestParam(required = false) String nombre) {
        return familiaService.searchFamilias(nombre);
    }

    @Operation(summary = "Actualizar una familia", description = "Actualiza una familia existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Familia actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Familia no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<FamiliaDTO> actualizarFamilia(@PathVariable @Valid Long id, @RequestBody FamiliaDTO familiaDTO) {
        Optional<FamiliaDTO> familiaActualizada = familiaService.updateFamilia(id, familiaDTO);
        return familiaActualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar una familia", description = "Elimina una familia específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Familia eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Familia no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFamilia(@PathVariable Long id) {
        familiaService.deleteFamilia(id);
        return ResponseEntity.noContent().build();
    }
}