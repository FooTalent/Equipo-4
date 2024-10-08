package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notificaciones")
public class NotificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(min = 10, max = 500, message = "El mensaje debe tener entre 10 y 500 caracteres")
    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @NotNull(message = "La fecha de envío no puede ser nula")
    @PastOrPresent(message = "La fecha de envío no puede ser futura")
    @Column(name = "fecha_envio", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaEnvio;

    @NotBlank(message = "El tipo de notificación no puede estar vacío")
    @Size(min = 3, max = 50, message = "El tipo de notificación debe tener entre 3 y 50 caracteres")
    @Column(name = "tipo_notificacion", nullable = false)
    private String tipoNotificacion;

    private boolean visto;
}