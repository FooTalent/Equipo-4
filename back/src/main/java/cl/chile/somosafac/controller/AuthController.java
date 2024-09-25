package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.security.AuthResponse;
import cl.chile.somosafac.service.AuthService;
import cl.chile.somosafac.security.LoginRequest;
import cl.chile.somosafac.security.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse token = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return ResponseEntity.ok("Logout exitoso");
    }
}
