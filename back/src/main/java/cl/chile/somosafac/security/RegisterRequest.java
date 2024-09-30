package cl.chile.somosafac.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String correo;
    String contrasenaHash;
    Role tipoUsuario;
    boolean activo = true;
    boolean verificado = false;
    LocalDateTime fechaUltimoAcceso;
    boolean aceptarTerminos;
}
