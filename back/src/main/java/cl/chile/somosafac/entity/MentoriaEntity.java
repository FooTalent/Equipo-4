package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mentorias")
public class MentoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "familia_mentora_id", nullable = false)
    private FamiliaEntity familiaMentora;

    @ManyToOne
    @JoinColumn(name = "familia_mentorada_id", nullable = false)
    private FamiliaEntity familiaMentorada;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "estado_mentoria", nullable = false, columnDefinition = "varchar(50) default 'Pendiente'")
    private String estadoMentoria;
}
