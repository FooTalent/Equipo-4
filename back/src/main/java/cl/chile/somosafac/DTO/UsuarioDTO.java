package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;


public class UsuarioDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("contrasenaHash")
    private String contrasenaHash;

    @JsonProperty("tipoUsuario")
    private String tipoUsuario;

    @JsonProperty("activo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "true|false")
    private Boolean activo;

    @JsonProperty("verificado")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "true|false")
    private Boolean verificado;

    @JsonProperty("fechaRegistro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaRegistro;

    @JsonProperty("fechaUltimoAcceso")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaUltimoAcceso;

    @JsonProperty("aceptarTerminos")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "true|false")
    private Boolean aceptarTerminos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(LocalDateTime fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public Boolean getAceptarTerminos() {
        return aceptarTerminos;
    }

    public void setAceptarTerminos(Boolean aceptarTerminos) {
        this.aceptarTerminos = aceptarTerminos;
    }

}