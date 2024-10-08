package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name = "voluntarios")
public class VoluntarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @NotBlank(message = "La ocupación no puede estar vacía")
    @Size(min = 3, max = 50, message = "La ocupación debe tener entre 3 y 50 caracteres")
    @Column(name = "ocupacion", nullable = false)
    private String ocupacion;

    @NotBlank(message = "El estado del voluntario no puede estar vacío")
    @Size(min = 3, max = 50, message = "El estado del voluntario debe tener entre 3 y 50 caracteres")
    @Column(name = "estado_voluntario", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'Activo'")
    private String estadoVoluntario;
}