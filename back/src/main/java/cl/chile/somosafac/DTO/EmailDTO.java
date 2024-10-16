package cl.chile.somosafac.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class EmailDTO {
    @NotNull(message = "Debe seleccionar el destinatario")
    private String destinatario;
    @NotNull(message = "El titulo del email no puede ser nulo")
    @NotBlank(message = "El titulo del email no puede estar vacío")
    private String titulo;
    @NotNull(message = "El mensaje del email no puede ser nulo")
    @NotBlank(message = "El mensaje del email no puede estar vacío")
    private String mensaje;
}
