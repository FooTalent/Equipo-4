package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotaDTO {

    @JsonProperty("id")
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @JsonProperty("familiaId")
    @NotNull(message = "La familia ID no puede ser nula")
    private Long familiaId;

    @JsonProperty("voluntarioId")
    @NotNull(message = "El voluntario ID no puede ser nulo")
    private Long voluntarioId;

    @JsonProperty("descripcion")
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    @JsonProperty("fechaCreacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "La fecha de creación no puede ser nula")
    @PastOrPresent(message = "La fecha de creación no puede ser futura")
    private LocalDateTime fechaCreacion;
}