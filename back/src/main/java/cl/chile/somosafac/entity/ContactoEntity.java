package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contactos")
public class ContactoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La familia no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "familia_id", nullable = false)
    private FamiliaEntity familia;

    @NotNull(message = "El usuario no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @NotNull(message = "La fecha de contacto no puede ser nula")
    @PastOrPresent(message = "La fecha de contacto no puede ser futura")
    @Column(name = "fecha_contacto", nullable = false)
    private LocalDateTime fechaContacto;

    @NotBlank(message = "La descripción de contacto no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción de contacto debe tener entre 10 y 500 caracteres")
    @Column(name = "descripcion_contacto")
    private String descripcionContacto;

}