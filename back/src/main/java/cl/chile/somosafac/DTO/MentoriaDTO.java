package cl.chile.somosafac.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MentoriaDTO {

    private Long id;
    private Long familiaMentoraId;
    private Long familiaMentoradaId;
    private LocalDateTime fechaAsignacion;
    private String estadoMentoria;
}
