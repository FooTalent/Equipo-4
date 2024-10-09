package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactoDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull(message = "La familia ID no puede ser nula")
    private Long familiaId;

    @NotNull(message = "El usuario ID no puede ser nulo")
    private Long usuarioId;

    @NotNull(message = "La fecha de contacto no puede ser nula")
    @PastOrPresent(message = "La fecha de contacto no puede ser futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaContacto;

    @NotBlank(message = "La descripción de contacto no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción de contacto debe tener entre 10 y 500 caracteres")
    private String descripcionContacto;
}