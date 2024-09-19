package cl.chile.somosafac.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotaDTO {

    private Long id;
    private Long familiaId;
    private Long voluntarioId;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}

