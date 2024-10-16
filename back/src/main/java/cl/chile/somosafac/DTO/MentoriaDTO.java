package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class MentoriaDTO {

    @JsonProperty("Id")
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @JsonProperty("familiaMentora")
    private Map<String, Object> familiaMentora;

    @JsonProperty("familiaMentorada")
    private Map<String, Object> familiaMentorada;

    @JsonProperty("fechaAsignacion")
    @NotNull(message = "La fecha de asignación no puede ser nula")
    @PastOrPresent(message = "La fecha de asignación no puede ser futura")
    private LocalDateTime fechaAsignacion;

    @JsonProperty("estadoMentoria")
    @NotBlank(message = "El estado de mentoria no puede estar vacío")
    @Size(min = 3, max = 50, message = "El estado de mentoria debe tener entre 3 y 50 caracteres")
    private String estadoMentoria;
}