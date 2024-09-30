package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name = "voluntarios")
public class VoluntarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "ocupacion", nullable = false)
    private String ocupacion;

    @Column(name = "estado_voluntario", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'Activo'")
    private String estadoVoluntario;
}
