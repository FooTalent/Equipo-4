package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.service.VoluntarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/voluntarios")
@Tag(name = "Voluntario", description = "Listado de operaciones de la entidad Voluntario")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @Operation(summary = "Obtener todos los voluntarios", description = "Obtiene todos los voluntarios registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Voluntarios obtenidos exitosamente")
    @GetMapping
    public ResponseEntity<List<VoluntarioDTO>> obtenerTodos() {
        List<VoluntarioDTO> voluntarios = voluntarioService.getAllVoluntarios();
        return ResponseEntity.ok(voluntarios);
    }

    @Operation(summary = "Obtener voluntario por ID", description = "Obtiene un voluntario específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voluntario encontrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Voluntario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> obtenerPorId(@PathVariable Long id) {
        VoluntarioDTO voluntario = voluntarioService.getVoluntario(id);
        return voluntario != null ? ResponseEntity.ok(voluntario) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear un nuevo voluntario", description = "Crea un nuevo voluntario en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Voluntario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<VoluntarioDTO> crearVoluntario(@RequestBody @Valid VoluntarioDTO voluntarioDTO) {
        VoluntarioDTO voluntario = voluntarioService.createVoluntario(voluntarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(voluntario);
    }

    @Operation(summary = "Actualizar un voluntario", description = "Actualiza un voluntario existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voluntario actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Voluntario no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> actualizarVoluntario(@PathVariable @Valid Long id, @RequestBody VoluntarioDTO voluntarioDTO) {
        VoluntarioDTO voluntario = voluntarioService.updateVoluntario(id, voluntarioDTO);
        return voluntario != null ? ResponseEntity.ok(voluntario) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un voluntario", description = "Elimina un voluntario específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Voluntario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Voluntario no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVoluntario(@PathVariable Long id) {
        voluntarioService.deleteVoluntario(id);
        return ResponseEntity.noContent().build();
    }
}