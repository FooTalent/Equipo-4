package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "familias")
public class FamiliaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "nombre_fa_uno", nullable = false, length = 255)
    private String nombreFaUno;

    @Column(name = "nombre_fa_dos", nullable = false, length = 255)
    private String nombreFaDos;

    @Column(name = "rut_fa_uno", unique = true, nullable = false, length = 12)
    private String rutFaUno;

    @Column(name = "rut_fa_dos", unique = true, nullable = false, length = 12)
    private String rutFaDos;

    @Column(name = "fecha_nacimiento_fa_uno", nullable = false)
    private LocalDate fechaNacimientoFaUno;

    @Column(name = "fecha_nacimiento_fa_dos", nullable = false)
    private LocalDate fechaNacimientoFaDos;

    @Column(name = "estado_civil", length = 50)
    private String estadoCivil;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "region", length = 100)
    private String region;

    @Column(name = "comuna", length = 100)
    private String comuna;

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "programa_fundacion_actual", length = 255)
    private String programaFundacionActual;

    @Column(name = "programa_fundacion_anterior", length = 255)
    private String programaFundacionAnterior;

    @Column(name = "ingreso_fa", precision = 10, scale = 2)
    private BigDecimal ingresoFa;

    @Column(name = "duracion_evaluacion")
    private Integer duracionEvaluacion;

    @Column(name = "tiempo_para_acoger")
    private Integer tiempoParaAcoger;

    @Column(name = "cantidad_acogimientos", columnDefinition = "INT DEFAULT 0")
    private Integer cantidadAcogimientos;

    @Column(name = "estado_acogimiento", length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'SA'")
    private String estadoAcogimiento;

    @Column(name = "fecha_inicio_acogimiento")
    private LocalDateTime fechaInicioAcogimiento;

    @Column(name = "edad_nna")
    private Integer edadNna;

    @Column(name = "rango_edad_nna", length = 50)
    private String rangoEdadNna;

    @Column(name = "sexo_nna", length = 10)
    private String sexoNna;

    @Column(name = "nacionalidad_nna", length = 100)
    private String nacionalidadNna;

    @Column(name = "tiempo_acogimiento")
    private Integer tiempoAcogimiento;

    @Column(name = "ingreso_afac", precision = 10, scale = 2)
    private BigDecimal ingresoAfac;

    @Column(name = "fecha_ultimo_contacto")
    private LocalDateTime fechaUltimoContacto;

    @CreatedBy
    private String usuarioCreacion;

    @CreatedDate
    private Date fechaCreacion;

    @LastModifiedDate
    private Date fechaModificacion;

}
