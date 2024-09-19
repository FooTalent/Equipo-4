package cl.chile.somosafac.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FamiliaDTO {

    private Long id;
    private String nombreFaUno;
    private String nombreFaDos;
    private String rutFaUno;
    private String rutFaDos;
    private LocalDate fechaNacimientoFaUno;
    private LocalDate fechaNacimientoFaDos;
    private String estadoCivil;
    private String telefono;
    private String email;
    private String region;
    private String comuna;
    private String direccion;
    private String programaFundacionActual;
    private String programaFundacionAnterior;
    private BigDecimal ingresoFa;
    private Integer duracionEvaluacion;
    private Integer tiempoParaAcoger;
    private Integer cantidadAcogimientos;
    private String estadoAcogimiento;
    private LocalDate fechaInicioAcogimiento;
    private Integer edadNna;
    private String rangoEdadNna;
    private String sexoNna;
    private String nacionalidadNna;
    private Integer tiempoAcogimiento;
    private BigDecimal ingresoAfac;
    private LocalDate fechaUltimoContacto;
}

