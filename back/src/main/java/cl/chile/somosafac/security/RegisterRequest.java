package cl.chile.somosafac.security;

import jakarta.validation.constraints.*;
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
    @NotNull(message = "El nombre no puede ser nulo.")
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El apellido no puede ser nulo.")
    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellido;

    @Email(message = "Debe ser un correo válido.")
    private String correo;

    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$",
            message = "La contraseña debe tener al menos una letra, un número y un símbolo especial"
    )
    private String contrasenaHash;

    private String cargo;

    @NotNull(message = "El tipo de Usuario debe ser ADMIN, FAMILIA o USUARIO")
    private Role tipoUsuario;

    private boolean activo = true;

    private boolean verificado = false;

    private LocalDateTime fechaUltimoAcceso;

    private boolean aceptarTerminos;

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = Role.valueOf(tipoUsuario.toUpperCase());
    }
}
