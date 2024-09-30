package cl.chile.somosafac.DTO;

import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.security.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;


@Data
public class UsuarioDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("correo")
    private String correo;

    @JsonIgnore
    @JsonProperty("contrasenaHash")
    private String contrasenaHash;

    @JsonProperty("tipoUsuario")
    private Role tipoUsuario;

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

    public UsuarioEntity toEntity() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(this.id);
        usuario.setCorreo(this.correo);
        usuario.setContrasenaHash(this.contrasenaHash);
        usuario.setTipoUsuario(this.tipoUsuario);
        usuario.setActivo(this.activo);
        usuario.setVerificado(this.verificado);
        usuario.setFechaRegistro(this.fechaRegistro);
        usuario.setFechaUltimoAcceso(this.fechaUltimoAcceso);
        usuario.setAceptarTerminos(this.aceptarTerminos);
        return usuario;
    }

    public static UsuarioDTO fromEntity(UsuarioEntity usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setContrasenaHash(usuario.getContrasenaHash());
        usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
        usuarioDTO.setActivo(usuario.getActivo());
        usuarioDTO.setVerificado(usuario.getVerificado());
        usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
        usuarioDTO.setFechaUltimoAcceso(usuario.getFechaUltimoAcceso());
        usuarioDTO.setAceptarTerminos(usuario.getAceptarTerminos());
        return usuarioDTO;
    }
}