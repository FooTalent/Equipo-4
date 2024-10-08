package cl.chile.somosafac.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MentoriaDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull(message = "La familia mentora ID no puede ser nula")
    private Long familiaMentoraId;

    @NotNull(message = "La familia mentorada ID no puede ser nula")
    private Long familiaMentoradaId;

    @NotNull(message = "La fecha de asignación no puede ser nula")
    @PastOrPresent(message = "La fecha de asignación no puede ser futura")
    private LocalDateTime fechaAsignacion;

    @NotBlank(message = "El estado de mentoria no puede estar vacío")
    @Size(min = 3, max = 50, message = "El estado de mentoria debe tener entre 3 y 50 caracteres")
    private String estadoMentoria;
}