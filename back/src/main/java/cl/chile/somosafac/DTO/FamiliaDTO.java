package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class FamiliaDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull(message = "El nombre del padre/madre 1 no puede ser nulo")
    @Size(min = 3, max = 255, message = "El nombre del padre/madre 1 debe tener entre 3 y 255 caracteres")
    @NotBlank(message = "El nombre del padre/madre 1 no puede estar vacío")
    private String nombreFaUno;

    @NotNull(message = "El nombre del padre/madre 2 no puede ser nulo")
    @Size(min = 3, max = 255, message = "El nombre del padre/madre 2 debe tener entre 3 y 255 caracteres")
    @NotBlank(message = "El nombre del padre/madre 2 no puede estar vacío")
    private String nombreFaDos;

    @NotNull(message = "El RUT del padre/madre 1 no puede ser nulo")
    @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 1 no es válido")
    @NotBlank(message = "El RUT del padre/madre 1 no puede estar vacío")
    private String rutFaUno;

    @NotNull(message = "El RUT del padre/madre 2 no puede ser nulo")
    @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 2 no es válido")
    @NotBlank(message = "El RUT del padre/madre 2 no puede estar vacío")
    private String rutFaDos;

    @NotNull(message = "La fecha de nacimiento del padre/madre 1 no puede ser nula")
    private LocalDate fechaNacimientoFaUno;

    @NotNull(message = "La fecha de nacimiento del padre/madre 2 no puede ser nula")
    private LocalDate fechaNacimientoFaDos;

    @NotNull(message = "El estado civil no puede ser nulo")
    @Size(min = 3, max = 50, message = "El estado civil debe tener entre 3 y 50 caracteres")
    @NotBlank(message = "El estado civil no puede estar vacío")
    private String estadoCivil;

    @NotNull(message = "El teléfono no puede ser nulo")
    @Size(min = 9, max = 20, message = "El teléfono debe tener entre 9 y 20 caracteres")
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El email no es válido")
    @Size(min = 5, max = 255, message = "El email debe tener entre 5 y 255 caracteres")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @NotNull(message = "La región no puede ser nula")
    @Size(min = 3, max = 100, message = "La región debe tener entre 3 y 100 caracteres")
    @NotBlank(message = "La región no puede estar vacía")
    private String region;

    @NotNull(message = "La comuna no puede ser nula")
    @Size(min = 3, max = 100, message = "La comuna debe tener entre 3 y 100 caracteres")
    @NotBlank(message = "La comuna no puede estar vacía")
    private String comuna;

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 10, max = 500, message = "La dirección debe tener entre 10 y 500 caracteres")
    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotNull(message = "La fecha de ingreso FA no puede ser nula")
    @PastOrPresent(message = "La fecha de ingreso FA no puede ser futura")
    @NotEmpty(message = "La fecha de ingreso FA no puede estar vacía")
    private LocalDate ingresoFa;

    @Min(1)
    private Integer duracionEvaluacion;

    @Min(1)
    private Integer tiempoParaAcoger;

    @Min(0)
    private Integer cantidadAcogimientos;


    private LocalDate fechaInicioAcogimiento;

    @Min(0)
    private Integer edadNna;

    @NotNull(message = "El rango de edad del NNA no puede ser nulo")
    @Size(min = 3, max = 50, message = "El rango de edad del NNA debe tener entre 3 y 50 caracteres")
    @NotBlank(message = "El rango de edad del NNA no puede estar vacío")
    private String rangoEdadNna;

    @NotNull(message = "El sexo del NNA no puede ser nulo")
    @Size(min = 3, max = 10, message = "El sexo del NNA debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El sexo del NNA no puede estar vacío")
    private String sexoNna;

    @NotNull(message = "La nacionalidad del NNA no puede ser nula")
    @Size(min = 3, max = 100, message = "La nacionalidad del NNA debe tener entre 3 y 100 caracteres")
    @NotBlank(message = "La nacionalidad del NNA no puede estar vacía")
    private String nacionalidadNna;

    @Min(1)
    private Integer tiempoAcogimiento;


    private LocalDate ingresoAfac;

    @JsonProperty("fechaUltimoContacto")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaUltimoContacto;

    private String programaFundacionActual;
    private String programaFundacionAnterior;
    private String usuarioCreacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaModificacion;

    private String estadoAcogimiento;
    private String usuario;
}