package cl.chile.somosafac.DTO;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificacionDTO {

    private Long id;
    private Long usuarioId;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private String tipoNotificacion;
}

