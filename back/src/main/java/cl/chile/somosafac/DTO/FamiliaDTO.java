package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FamiliaDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotBlank(message = "El nombre del padre/madre 1 no puede estar vacío")
    private String nombreFaUno;

    @NotBlank(message = "El nombre del padre/madre 2 no puede estar vacío")
    private String nombreFaDos;

    @NotBlank(message = "El RUT del padre/madre 1 no puede estar vacío")
    @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 1 no es válido")
    private String rutFaUno;

    @NotBlank(message = "El RUT del padre/madre 2 no puede estar vacío")
    @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 2 no es válido")
    private String rutFaDos;

    @NotNull(message = "La fecha de nacimiento del padre/madre 1 no puede ser nula")
    private LocalDate fechaNacimientoFaUno;

    @NotNull(message = "La fecha de nacimiento del padre/madre 2 no puede ser nula")
    private LocalDate fechaNacimientoFaDos;

    @NotBlank(message = "El estado civil no puede estar vacío")
    private String estadoCivil;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email no es válido")
    private String email;

    @NotBlank(message = "La región no puede estar vacía")
    private String region;

    @NotBlank(message = "La comuna no puede estar vacía")
    private String comuna;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal ingresoFa;

    @Min(1)
    private Integer duracionEvaluacion;

    @Min(1)
    private Integer tiempoParaAcoger;

    @Min(0)
    private Integer cantidadAcogimientos;

    @NotNull(message = "La fecha de inicio de acogimiento no puede ser nula")
    private LocalDate fechaInicioAcogimiento;

    @Min(0)
    private Integer edadNna;

    @NotBlank(message = "El rango de edad del NNA no puede estar vacío")
    private String rangoEdadNna;

    @NotBlank(message = "El sexo del NNA no puede estar vacío")
    private String sexoNna;

    @NotBlank(message = "La nacionalidad del NNA no puede estar vacía")
    private String nacionalidadNna;

    @Min(1)
    private Integer tiempoAcogimiento;

    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal ingresoAfac;

    @JsonProperty("fechaUltimoAcceso")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate fechaUltimoContacto;

}