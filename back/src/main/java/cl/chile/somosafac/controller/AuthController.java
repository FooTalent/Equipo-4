package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.PasswordDTO;
import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.service.AuthService;
import cl.chile.somosafac.security.LoginRequest;
import cl.chile.somosafac.security.RegisterRequest;
import cl.chile.somosafac.service.EmailService;
import cl.chile.somosafac.service.UsuarioService;
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
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;
    private final EmailService emailService;

    @PostMapping(value = "login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody @Valid LoginRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authService.login(request, response));
    }

    @PostMapping(value = "register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody RegisterRequest request) {
        UsuarioDTO usuarioRegistrado = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        // Invalida la cookie al cerrar sesion
        Cookie jwtCookie = new Cookie("token", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setSecure(true);
        jwtCookie.setMaxAge(0);
        response.addCookie(jwtCookie);

        System.out.println("Cookie login: " + jwtCookie.getName());
        System.out.println(jwtCookie.getValue());

        return ResponseEntity.ok("Logout exitoso");
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<String> cambiarContrasenaPrimerIngreso(@PathVariable Long id, @RequestBody PasswordDTO nuevaContrasena) {
        authService.cambiarContrasenaPrimerIngreso(id, nuevaContrasena);
        return ResponseEntity.ok("Contraseña actualizada exitosamente.");
    }

    // Recuperar contrasena
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

    @PostMapping("/reset-password/{resetToken}")
    public ResponseEntity<String> recuperarContrasena(@PathVariable String resetToken, @RequestBody PasswordDTO nuevaContrasena) {
        UsuarioEntity usuario = authService.validarResetToken(resetToken);

        authService.resetContrasena(usuario, nuevaContrasena.getPassword());
        return ResponseEntity.ok("Contraseña reestablecida exitosamente.");
    }
}
