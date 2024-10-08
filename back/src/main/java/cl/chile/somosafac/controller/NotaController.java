package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.service.NotaService;
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
@RequestMapping("/api/notas")
@Tag(name = "Nota", description = "Listado de operaciones de la entidad Nota")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @Operation(summary = "Obtener todas las notas", description = "Obtiene todas las notas registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Notas obtenidas exitosamente")
    @GetMapping
    public ResponseEntity<List<NotaDTO>> obtenerTodas() {
        List<NotaDTO> notas = notaService.getNotas();
        return ResponseEntity.ok(notas);
    }

    @Operation(summary = "Obtener nota por ID", description = "Obtiene una nota específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota encontrada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Nota no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtenerPorId(@PathVariable Long id) {
        NotaDTO nota = notaService.getNota(id);
        return nota != null ? ResponseEntity.ok(nota) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear una nueva nota", description = "Crea una nueva nota en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<NotaDTO> crearNota(@RequestBody @Valid NotaDTO notaDTO, @RequestBody FamiliaEntity familia, VoluntarioEntity voluntario) {
        NotaDTO nota = notaService.createNota(notaDTO, familia, voluntario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nota);
    }

    @Operation(summary = "Actualizar una nota", description = "Actualiza una nota existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Nota no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<NotaDTO> actualizarNota(@PathVariable @Valid Long id, @RequestBody NotaDTO notaDTO, @RequestBody FamiliaEntity familia, @RequestBody VoluntarioEntity voluntario) {
        NotaDTO nota = notaService.updateNota(id, notaDTO, familia, voluntario);
        return nota != null ? ResponseEntity.ok(nota) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una nota", description = "Elimina una nota específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Nota no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        notaService.deleteNota(id);
        return ResponseEntity.ok().build();
    }
}