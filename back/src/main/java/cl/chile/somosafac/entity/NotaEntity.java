package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notas")
@Getter
@Setter
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La familia no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "familia_id", nullable = false)
    private FamiliaEntity familia;

    @NotNull(message = "El voluntario no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "voluntario_id", nullable = false)
    private VoluntarioEntity voluntario;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "La fecha de creación no puede ser nula")
    @PastOrPresent(message = "La fecha de creación no puede ser futura")
    @Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;
}