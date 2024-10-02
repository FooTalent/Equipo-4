package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.service.NotificacionService;
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
@RequestMapping("/api/notificaciones")
@Tag(name = "Notificación", description = "Listado de operaciones de la entidad Notificación")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @Operation(summary = "Obtener todas las notificaciones", description = "Obtiene todas las notificaciones del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificaciones encontradas exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron notificaciones")
    })
    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> obtenerTodasLasNotificaciones() {
        List<NotificacionDTO> notificaciones = notificacionService.getAllNotificaciones();
        return ResponseEntity.ok(notificaciones);
    }

    @Operation(summary = "Obtener notificación por ID", description = "Obtiene una notificación específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificación encontrada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> obtenerNotificacion(@PathVariable Long id) {
        NotificacionDTO notificacion = notificacionService.getNotificacion(id);
        return notificacion != null ? ResponseEntity.ok(notificacion) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear una nueva notificación", description = "Crea una nueva notificación en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notificación creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<NotificacionDTO> crearNotificacion(@Valid @RequestBody NotificacionDTO notificacionDTO) {
        NotificacionDTO notificacion = notificacionService.createNotificacion(notificacionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacion);
    }

    @Operation(summary = "Actualizar una notificación", description = "Actualiza una notificación existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificación actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDTO> actualizarNotificacion(@PathVariable Long id, @Valid @RequestBody NotificacionDTO notificacionDTO) {
        NotificacionDTO notificacion = notificacionService.updateNotificacion(id, notificacionDTO);
        return notificacion != null ? ResponseEntity.ok(notificacion) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una notificación", description = "Elimina una notificación específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notificación eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        notificacionService.deleteNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}