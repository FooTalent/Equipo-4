package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.service.MentoriaService;
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
@RequestMapping("/api/mentorias")
@Tag(name = "Mentoría", description = "Listado de operaciones de la entidad Mentoría")
public class MentoriaController {

    private final MentoriaService mentoriaService;

    public MentoriaController(MentoriaService mentoriaService) {
        this.mentoriaService = mentoriaService;
    }

    @Operation(summary = "Obtener todas las mentorías", description = "Obtiene todas las mentorías registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Mentorías obtenidas exitosamente")
    @GetMapping
    public ResponseEntity<List<MentoriaDTO>> obtenerTodas() {
        List<MentoriaDTO> mentorias = mentoriaService.getMentorias();
        return ResponseEntity.ok(mentorias);
    }

    @Operation(summary = "Obtener mentoría por ID", description = "Obtiene una mentoría específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentoría encontrada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mentoría no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> obtenerPorId(@PathVariable Long id) {
        MentoriaDTO mentoria = mentoriaService.getMentoria(id);
        return mentoria != null ? ResponseEntity.ok(mentoria) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear una nueva mentoría", description = "Crea una nueva mentoría en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mentoría creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<MentoriaDTO> crearMentoria(@RequestBody @Valid MentoriaDTO mentoriaDTO) {
        MentoriaDTO mentoria = mentoriaService.createMentoria(mentoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentoria);
    }

    @Operation(summary = "Actualizar una mentoría", description = "Actualiza una mentoría existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mentoría actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mentoría no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MentoriaDTO> actualizarMentoria(@PathVariable @Valid Long id, @RequestBody MentoriaDTO mentoriaDTO) {
        Optional<MentoriaDTO> mentoriaOptional = mentoriaService.updateMentoria(id, mentoriaDTO);
        return mentoriaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar una mentoría", description = "Elimina una mentoría específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Mentoría eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mentoría no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMentoria(@PathVariable Long id) {
        mentoriaService.deleteMentoria(id);
        return ResponseEntity.noContent().build();
    }
}