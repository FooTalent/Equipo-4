package cl.chile.somosafac.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getNombreFaUno() {
        return nombreFaUno;
    }

    public void setNombreFaUno(String nombreFaUno) {
        this.nombreFaUno = nombreFaUno;
    }

    public String getNombreFaDos() {
        return nombreFaDos;
    }

    public void setNombreFaDos(String nombreFaDos) {
        this.nombreFaDos = nombreFaDos;
    }

    public String getRutFaUno() {
        return rutFaUno;
    }

    public void setRutFaUno(String rutFaUno) {
        this.rutFaUno = rutFaUno;
    }

    public String getRutFaDos() {
        return rutFaDos;
    }

    public void setRutFaDos(String rutFaDos) {
        this.rutFaDos = rutFaDos;
    }

    public LocalDate getFechaNacimientoFaUno() {
        return fechaNacimientoFaUno;
    }

    public void setFechaNacimientoFaUno(LocalDate fechaNacimientoFaUno) {
        this.fechaNacimientoFaUno = fechaNacimientoFaUno;
    }

    public LocalDate getFechaNacimientoFaDos() {
        return fechaNacimientoFaDos;
    }

    public void setFechaNacimientoFaDos(LocalDate fechaNacimientoFaDos) {
        this.fechaNacimientoFaDos = fechaNacimientoFaDos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProgramaFundacionActual() {
        return programaFundacionActual;
    }

    public void setProgramaFundacionActual(String programaFundacionActual) {
        this.programaFundacionActual = programaFundacionActual;
    }

    public String getProgramaFundacionAnterior() {
        return programaFundacionAnterior;
    }

    public void setProgramaFundacionAnterior(String programaFundacionAnterior) {
        this.programaFundacionAnterior = programaFundacionAnterior;
    }

    public BigDecimal getIngresoFa() {
        return ingresoFa;
    }

    public void setIngresoFa(BigDecimal ingresoFa) {
        this.ingresoFa = ingresoFa;
    }

    public Integer getDuracionEvaluacion() {
        return duracionEvaluacion;
    }

    public void setDuracionEvaluacion(Integer duracionEvaluacion) {
        this.duracionEvaluacion = duracionEvaluacion;
    }

    public Integer getTiempoParaAcoger() {
        return tiempoParaAcoger;
    }

    public void setTiempoParaAcoger(Integer tiempoParaAcoger) {
        this.tiempoParaAcoger = tiempoParaAcoger;
    }

    public Integer getCantidadAcogimientos() {
        return cantidadAcogimientos;
    }

    public void setCantidadAcogimientos(Integer cantidadAcogimientos) {
        this.cantidadAcogimientos = cantidadAcogimientos;
    }

    public String getEstadoAcogimiento() {
        return estadoAcogimiento;
    }

    public void setEstadoAcogimiento(String estadoAcogimiento) {
        this.estadoAcogimiento = estadoAcogimiento;
    }

    public LocalDateTime getFechaInicioAcogimiento() {
        return fechaInicioAcogimiento;
    }

    public void setFechaInicioAcogimiento(LocalDateTime fechaInicioAcogimiento) {
        this.fechaInicioAcogimiento = fechaInicioAcogimiento;
    }

    public Integer getEdadNna() {
        return edadNna;
    }

    public void setEdadNna(Integer edadNna) {
        this.edadNna = edadNna;
    }

    public String getRangoEdadNna() {
        return rangoEdadNna;
    }

    public void setRangoEdadNna(String rangoEdadNna) {
        this.rangoEdadNna = rangoEdadNna;
    }

    public String getSexoNna() {
        return sexoNna;
    }

    public void setSexoNna(String sexoNna) {
        this.sexoNna = sexoNna;
    }

    public String getNacionalidadNna() {
        return nacionalidadNna;
    }

    public void setNacionalidadNna(String nacionalidadNna) {
        this.nacionalidadNna = nacionalidadNna;
    }

    public Integer getTiempoAcogimiento() {
        return tiempoAcogimiento;
    }

    public void setTiempoAcogimiento(Integer tiempoAcogimiento) {
        this.tiempoAcogimiento = tiempoAcogimiento;
    }

    public BigDecimal getIngresoAfac() {
        return ingresoAfac;
    }

    public void setIngresoAfac(BigDecimal ingresoAfac) {
        this.ingresoAfac = ingresoAfac;
    }

    public LocalDateTime getFechaUltimoContacto() {
        return fechaUltimoContacto;
    }

    public void setFechaUltimoContacto(LocalDateTime fechaUltimoContacto) {
        this.fechaUltimoContacto = fechaUltimoContacto;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
