package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.RequestActualizarUsuarioDTO;
import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.service.UsuarioService;
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
@RequestMapping("/api/usuarios")
@Tag(name = "Usuario", description = "Listado de operaciones de la entidad Usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Obtiene todos los usuarios registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Usuarios obtenidos exitosamente")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Obtener usuario por ID", description = "Obtiene un usuario específico por su ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Usuario encontrado exitosamente"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.obtenerPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Actualizar un usuario", description = "Actualiza un usuario existente por su ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@Valid @PathVariable Long id,@Valid @RequestBody RequestActualizarUsuarioDTO usuarioActualizados) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioActualizados);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario específico por su ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok().build();
    }
}