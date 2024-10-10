package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mentorias")
public class MentoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La familia mentora no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "familia_mentora_id", nullable = false)
    private FamiliaEntity familiaMentora;

    @NotNull(message = "La familia mentorada no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "familia_mentorada_id", nullable = false)
    private FamiliaEntity familiaMentorada;

    @NotNull(message = "La fecha de asignación no puede ser nula")
    @PastOrPresent(message = "La fecha de asignación no puede ser futura")
    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @NotBlank(message = "El estado de mentoria no puede estar vacío")
    @Size(min = 3, max = 50, message = "El estado de mentoria debe tener entre 3 y 50 caracteres")
    @Column(name = "estado_mentoria", nullable = false, columnDefinition = "varchar(50) default 'Pendiente'")
    private String estadoMentoria;
}