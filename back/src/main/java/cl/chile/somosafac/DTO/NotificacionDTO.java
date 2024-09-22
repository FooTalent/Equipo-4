package cl.chile.somosafac.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificacionDTO {

    private Long id;
    private Long usuarioId;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private String tipoNotificacion;
}

