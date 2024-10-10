package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.PasswordDTO;
import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.service.AuthService;
import cl.chile.somosafac.security.LoginRequest;
import cl.chile.somosafac.security.RegisterRequest;
import cl.chile.somosafac.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "Operaciones relacionadas con la autenticación de usuarios")
public class AuthController {

    private final AuthService authService;
    private final EmailService emailService;

    @Operation(summary = "Iniciar sesión", description = "Autentica a un usuario con su correo electrónico y contraseña")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario autenticado exitosamente"),
            @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
    })
    @PostMapping(value = "login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authService.login(request, response));
    }

    @Operation(summary = "Registrar un nuevo usuario", description = "Registra un nuevo usuario en la plataforma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en el registro del usuario")
    })
    @PostMapping(value = "register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody RegisterRequest request) {
        UsuarioDTO usuarioRegistrado = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }

    @Operation(summary = "Cerrar sesión", description = "Cierra la sesión del usuario actual y elimina el token de autenticación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cierre de sesión exitoso")
    })
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        Cookie jwtCookie = new Cookie("token", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setSecure(true);
        jwtCookie.setMaxAge(0);
        response.addCookie(jwtCookie);

        return ResponseEntity.ok("Logout exitoso");
    }

    @Operation(summary = "Cambiar contraseña", description = "Permite al usuario cambiar su contraseña en su primer ingreso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contraseña actualizada exitosamente")
    })
    @PutMapping("/password")
    public ResponseEntity<String> cambiarContrasenaPrimerIngreso(@RequestParam String email,@Valid @RequestBody PasswordDTO nuevaContrasena) {
        authService.cambiarContrasenaPrimerIngreso(email, nuevaContrasena);
        return ResponseEntity.ok("Contraseña actualizada exitosamente.");
    }

    @Operation(summary = "Solicitar recuperación de contraseña", description = "Envía un enlace de recuperación de contraseña al correo electrónico del usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enlace de recuperación enviado por email"),
            @ApiResponse(responseCode = "404", description = "Correo electrónico no encontrado")
    })
    @PostMapping("/solicitar-recuperar-password")
    public ResponseEntity<String> solicitarRecuperarContrasena(@RequestParam String email) {
        String resetToken = authService.generarResetToken(email);
        String resetLink = "http://localhost:5173/reset-password/" + resetToken;

        emailService.enviarEmail(
                email,
                "Somos AFAC - Reestablecer Contraseña \uD83D\uDD10",
                "Click en el enlace para ingresar tu nueva contraseña " + resetLink);

        return ResponseEntity.ok("Enlace de recuperación enviado por email.");
    }

    @Operation(summary = "Restablecer contraseña", description = "Permite al usuario restablecer su contraseña usando un código de recuperación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contraseña restablecida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Código de recuperación inválido o expirado")
    })
    @PostMapping("/reset-password/{resetToken}")
    public ResponseEntity<String> recuperarContrasena(@PathVariable String resetToken,@Valid @RequestBody PasswordDTO nuevaContrasena) {
        UsuarioEntity usuario = authService.validarResetToken(resetToken);

        authService.resetContrasena(usuario, nuevaContrasena.getContrasenaHash());
        return ResponseEntity.ok("Contraseña reestablecida exitosamente.");
    }
}
