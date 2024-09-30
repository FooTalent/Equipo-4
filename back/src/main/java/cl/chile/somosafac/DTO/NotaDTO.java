package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("familiaId")
    private Long familiaId;

    @JsonProperty("voluntarioId")
    private Long voluntarioId;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("fechaCreacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;
}