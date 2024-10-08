package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class VoluntarioDTO {

   @JsonProperty("Id")
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;
    @JsonProperty("usuarioId")
    @NotNull(message = "El usuario ID no puede ser nulo")
    private Long usuarioId;

    @JsonProperty("Ocupacion")
    @NotBlank(message = "La ocupación no puede estar vacía")
    @Size(min = 3, max = 50, message = "La ocupación debe tener entre 3 y 50 caracteres")
    private String ocupacion;

    @JsonProperty("EstadoVoluntario")
    @NotBlank(message = "El estado del voluntario no puede estar vacío")
    @Size(min = 3, max = 50, message = "El estado del voluntario debe tener entre 3 y 50 caracteres")
    private String estadoVoluntario;
}