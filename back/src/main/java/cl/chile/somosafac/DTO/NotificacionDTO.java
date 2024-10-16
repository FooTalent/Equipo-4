package cl.chile.somosafac.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacionDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull(message = "El usuario ID no puede ser nulo")
    private Long usuarioId;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(min = 10, max = 500, message = "El mensaje debe tener entre 10 y 500 caracteres")
    private String mensaje;

    private String tipoNotificacion;

    @NotNull(message = "La fecha de envío no puede ser nula")
    @PastOrPresent(message = "La fecha de envío no puede ser futura")
    private LocalDateTime fechaEnvio;

    private boolean visto;
}