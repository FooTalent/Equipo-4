package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.ContactoDTO;
import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.service.ContactoService;
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
@RequestMapping("/api/contactos")
@Tag(name = "Contacto", description = "Listado de operaciones de la entidad Contacto")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @Operation(summary = "Obtener todas las familias con contactos", description = "Obtiene todas las familias con sus respectivos contactos")
    @ApiResponse(responseCode = "200", description = "Familias obtenidas exitosamente")
    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> obtenerTodas() {
        List<FamiliaDTO> familias = contactoService.listarFamiliasConContacto();
        return ResponseEntity.ok(familias);
    }

    @Operation(summary = "Obtener historial de contactos de una familia", description = "Obtiene el historial de contactos de una familia específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial de contactos encontrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Familia no encontrada")
    })
    @GetMapping("/{familiaId}")
    public ResponseEntity<List<ContactoDTO>> obtenerHistorialContactoFamilia(@PathVariable Long familiaId) {
        List<ContactoDTO> contactos = contactoService.obtenerHistorialContactoFamilia(familiaId);
        return ResponseEntity.ok(contactos);
    }

    @Operation(summary = "Programar contacto con una familia", description = "Crea un nuevo contacto con una familia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contacto programado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de creación")
    })
    @PostMapping
    public ResponseEntity<ContactoDTO> programarContacto(@RequestBody @Valid ContactoDTO contactoDTO) {
        ContactoDTO contacto = contactoService.programarContacto(contactoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(contacto);
    }

    @Operation(summary = "Obtener notificaciones pendientes", description = "Obtiene las notificaciones pendientes")
    @ApiResponse(responseCode = "200", description = "Notificaciones obtenidas exitosamente")
    @GetMapping("/notificaciones/pendientes")
    public ResponseEntity<List<NotificacionDTO>> obtenerNotificacionesPendientes() {
        List<NotificacionDTO> notificaciones = contactoService.obtenerNotificacionesPendientes();
        return ResponseEntity.ok(notificaciones);
    }

    @Operation(summary = "Marcar notificación como leída", description = "Marcar una notificación como leída")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notificación marcada como leída exitosamente"),
            @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    })
    @PatchMapping("/notificaciones/{notificacionId}")
    public ResponseEntity<Void> marcarNotificacionComoLeida(@PathVariable Long notificacionId) {
        contactoService.marcarNotificacionComoLeida(notificacionId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Actualizar contacto", description = "Actualiza un contacto")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Contacto actualizado exitosamente"), @ApiResponse(responseCode = "404", description = "Contacto no encontrado"), @ApiResponse(responseCode = "200", description = "Contacto actualizado exitosamente"), @ApiResponse(responseCode = "404", description = "Contacto no encontrado")})
    @PutMapping("/{contactoId}")
    public ResponseEntity<ContactoDTO> actualizarContacto(@PathVariable Long contactoId, @RequestBody @Valid ContactoDTO contactoDTO) {
        ContactoDTO contactoActualizado = contactoService.actualizarContacto(contactoId, contactoDTO);
        return ResponseEntity.ok(contactoActualizado);
    }

    @Operation(summary = "Obtener contacto por ID", description = "Obtiene un contacto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contacto encontrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Contacto no encontrado")
    })
    @GetMapping("/{contactoId}")
    public ResponseEntity<ContactoDTO> obtenerContactoPorId(@PathVariable Long contactoId) {
        ContactoDTO contacto = contactoService.obtenerContactoPorId(contactoId);
        return ResponseEntity.ok(contacto);
    }
}