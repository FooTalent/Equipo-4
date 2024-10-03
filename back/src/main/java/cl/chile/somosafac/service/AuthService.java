package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.UsuarioRepository;
import cl.chile.somosafac.security.JwtService;
import cl.chile.somosafac.security.LoginRequest;
import cl.chile.somosafac.security.RegisterRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UsuarioDTO login(LoginRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasenaHash()));
        UsuarioEntity usuario = usuarioRepository.findByCorreo(request.getCorreo()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado."));

        usuario.setFechaUltimoAcceso(LocalDateTime.now());
        usuarioRepository.save(usuario);

        String token = jwtService.getToken(usuario);
        // Configuracion de la cookie
        Cookie jwtCookie = new Cookie("token", token);
        jwtCookie.setHttpOnly(true);  // Evita que la cookie accesible desde JavaScript
        jwtCookie.setPath("/");
        jwtCookie.setSecure(true);
        jwtCookie.setMaxAge(24 * 60 * 60); // Duracion de 1 dia - Consultar con equipo
        response.addCookie(jwtCookie);

        UsuarioDTO usuarioDTO = UsuarioDTO.fromEntity(usuario);
        System.out.println("Cookie logout: " + jwtCookie.getName());
        System.out.println(jwtCookie.getValue());
        return usuarioDTO;
    }

    public UsuarioDTO register(RegisterRequest request) {
        if (usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está en uso");
        }

        UsuarioEntity usuario = UsuarioEntity.builder()
                .correo(request.getCorreo())
                .contrasenaHash(passwordEncoder.encode(request.getContrasenaHash()))
                .tipoUsuario(request.getTipoUsuario())
                .fechaRegistro(LocalDateTime.now())
                .aceptarTerminos(request.isAceptarTerminos())
                .activo(true)
                .build();

        usuarioRepository.save(usuario);

        UsuarioDTO usuarioDTO = UsuarioDTO.fromEntity(usuario);
        return usuarioDTO;
    }
}
