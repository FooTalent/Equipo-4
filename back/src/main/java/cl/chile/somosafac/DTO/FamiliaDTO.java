package cl.chile.somosafac.DTO;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


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
    @Past(message = "La fecha de nacimiento del padre/madre 1 no puede ser en el futuro")
    private LocalDate fechaNacimientoFaUno;

    @NotNull(message = "La fecha de nacimiento del padre/madre 2 no puede ser nula")
    @Past(message = "La fecha de nacimiento del padre/madre 2 no puede ser en el futuro")
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

    @NotNull(message = "La fecha del último contacto no puede ser nula")
    private LocalDate fechaUltimoContacto;

    public @NotNull(message = "El ID no puede ser nulo") Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "El ID no puede ser nulo") Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre del padre/madre 1 no puede estar vacío") String getNombreFaUno() {
        return nombreFaUno;
    }

    public void setNombreFaUno(@NotBlank(message = "El nombre del padre/madre 1 no puede estar vacío") String nombreFaUno) {
        this.nombreFaUno = nombreFaUno;
    }

    public @NotBlank(message = "El nombre del padre/madre 2 no puede estar vacío") String getNombreFaDos() {
        return nombreFaDos;
    }

    public void setNombreFaDos(@NotBlank(message = "El nombre del padre/madre 2 no puede estar vacío") String nombreFaDos) {
        this.nombreFaDos = nombreFaDos;
    }

    public @NotBlank(message = "El RUT del padre/madre 1 no puede estar vacío") @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 1 no es válido") String getRutFaUno() {
        return rutFaUno;
    }

    public void setRutFaUno(@NotBlank(message = "El RUT del padre/madre 1 no puede estar vacío") @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 1 no es válido") String rutFaUno) {
        this.rutFaUno = rutFaUno;
    }

    public @NotBlank(message = "El RUT del padre/madre 2 no puede estar vacío") @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 2 no es válido") String getRutFaDos() {
        return rutFaDos;
    }

    public void setRutFaDos(@NotBlank(message = "El RUT del padre/madre 2 no puede estar vacío") @Pattern(regexp = "^[0-9]{9}-[Kk|0-9]$", message = "El RUT del padre/madre 2 no es válido") String rutFaDos) {
        this.rutFaDos = rutFaDos;
    }

    public @NotNull(message = "La fecha de nacimiento del padre/madre 1 no puede ser nula") @Past(message = "La fecha de nacimiento del padre/madre 1 no puede ser en el futuro") LocalDate getFechaNacimientoFaUno() {
        return fechaNacimientoFaUno;
    }

    public void setFechaNacimientoFaUno(@NotNull(message = "La fecha de nacimiento del padre/madre 1 no puede ser nula") @Past(message = "La fecha de nacimiento del padre/madre 1 no puede ser en el futuro") LocalDate fechaNacimientoFaUno) {
        this.fechaNacimientoFaUno = fechaNacimientoFaUno;
    }

    public @NotNull(message = "La fecha de nacimiento del padre/madre 2 no puede ser nula") @Past(message = "La fecha de nacimiento del padre/madre 2 no puede ser en el futuro") LocalDate getFechaNacimientoFaDos() {
        return fechaNacimientoFaDos;
    }

    public void setFechaNacimientoFaDos(@NotNull(message = "La fecha de nacimiento del padre/madre 2 no puede ser nula") @Past(message = "La fecha de nacimiento del padre/madre 2 no puede ser en el futuro") LocalDate fechaNacimientoFaDos) {
        this.fechaNacimientoFaDos = fechaNacimientoFaDos;
    }

    public @NotBlank(message = "El estado civil no puede estar vacío") String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotBlank(message = "El estado civil no puede estar vacío") String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public @NotBlank(message = "El teléfono no puede estar vacío") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El teléfono no puede estar vacío") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "El email no puede estar vacío") @Email(message = "El email no es válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email no puede estar vacío") @Email(message = "El email no es válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "La región no puede estar vacía") String getRegion() {
        return region;
    }

    public void setRegion(@NotBlank(message = "La región no puede estar vacía") String region) {
        this.region = region;
    }

    public @NotBlank(message = "La comuna no puede estar vacía") String getComuna() {
        return comuna;
    }

    public void setComuna(@NotBlank(message = "La comuna no puede estar vacía") String comuna) {
        this.comuna = comuna;
    }

    public @NotBlank(message = "La dirección no puede estar vacía") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotBlank(message = "La dirección no puede estar vacía") String direccion) {
        this.direccion = direccion;
    }

    public @DecimalMin(value = "0.00", inclusive = true) BigDecimal getIngresoFa() {
        return ingresoFa;
    }

    public void setIngresoFa(@DecimalMin(value = "0.00", inclusive = true) BigDecimal ingresoFa) {
        this.ingresoFa = ingresoFa;
    }

    public @Min(1) Integer getDuracionEvaluacion() {
        return duracionEvaluacion;
    }

    public void setDuracionEvaluacion(@Min(1) Integer duracionEvaluacion) {
        this.duracionEvaluacion = duracionEvaluacion;
    }

    public @Min(1) Integer getTiempoParaAcoger() {
        return tiempoParaAcoger;
    }

    public void setTiempoParaAcoger(@Min(1) Integer tiempoParaAcoger) {
        this.tiempoParaAcoger = tiempoParaAcoger;
    }

    public @Min(0) Integer getCantidadAcogimientos() {
        return cantidadAcogimientos;
    }

    public void setCantidadAcogimientos(@Min(0) Integer cantidadAcogimientos) {
        this.cantidadAcogimientos = cantidadAcogimientos;
    }

    public @NotNull(message = "La fecha de inicio de acogimiento no puede ser nula") LocalDate getFechaInicioAcogimiento() {
        return fechaInicioAcogimiento;
    }

    public void setFechaInicioAcogimiento(@NotNull(message = "La fecha de inicio de acogimiento no puede ser nula") LocalDate fechaInicioAcogimiento) {
        this.fechaInicioAcogimiento = fechaInicioAcogimiento;
    }

    public @Min(0) Integer getEdadNna() {
        return edadNna;
    }

    public void setEdadNna(@Min(0) Integer edadNna) {
        this.edadNna = edadNna;
    }

    public @NotBlank(message = "El rango de edad del NNA no puede estar vacío") String getRangoEdadNna() {
        return rangoEdadNna;
    }

    public void setRangoEdadNna(@NotBlank(message = "El rango de edad del NNA no puede estar vacío") String rangoEdadNna) {
        this.rangoEdadNna = rangoEdadNna;
    }

    public @NotBlank(message = "El sexo del NNA no puede estar vacío") String getSexoNna() {
        return sexoNna;
    }

    public void setSexoNna(@NotBlank(message = "El sexo del NNA no puede estar vacío") String sexoNna) {
        this.sexoNna = sexoNna;
    }

    public @NotBlank(message = "La nacionalidad del NNA no puede estar vacía") String getNacionalidadNna() {
        return nacionalidadNna;
    }

    public void setNacionalidadNna(@NotBlank(message = "La nacionalidad del NNA no puede estar vacía") String nacionalidadNna) {
        this.nacionalidadNna = nacionalidadNna;
    }

    public @Min(1) Integer getTiempoAcogimiento() {
        return tiempoAcogimiento;
    }

    public void setTiempoAcogimiento(@Min(1) Integer tiempoAcogimiento) {
        this.tiempoAcogimiento = tiempoAcogimiento;
    }

    public @DecimalMin(value = "0.00", inclusive = true) BigDecimal getIngresoAfac() {
        return ingresoAfac;
    }

    public void setIngresoAfac(@DecimalMin(value = "0.00", inclusive = true) BigDecimal ingresoAfac) {
        this.ingresoAfac = ingresoAfac;
    }

    public @NotNull(message = "La fecha del último contacto no puede ser nula") LocalDate getFechaUltimoContacto() {
        return fechaUltimoContacto;
    }

    public void setFechaUltimoContacto(@NotNull(message = "La fecha del último contacto no puede ser nula") LocalDate fechaUltimoContacto) {
        this.fechaUltimoContacto = fechaUltimoContacto;
    }
}