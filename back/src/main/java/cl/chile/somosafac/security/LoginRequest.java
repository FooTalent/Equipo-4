package cl.chile.somosafac.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotEmpty(message = "Por favor, introduzca un correo electronico valido")
    @Email(message = "Debe ser un correo válido.")
    String correo;

    @NotEmpty(message = "Por favor, ingrese su contraseña")
    String contrasenaHash;
}

