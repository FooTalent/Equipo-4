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

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("correo")
    private String correo;

    @JsonIgnore
    @JsonProperty("contrasenaHash")
    private String contrasenaHash;

    @JsonProperty("cargo")
    private String cargo;

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

    @JsonProperty("primerIngreso")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "true|false")
    private Boolean primerIngreso;

    @JsonIgnore
    @JsonProperty("resetToken")
    private String resetToken;

    public UsuarioEntity toEntity() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        usuario.setNombre(this.apellido);
        usuario.setCorreo(this.correo);
        usuario.setContrasenaHash(this.contrasenaHash);
        usuario.setCargo(this.cargo);
        usuario.setTipoUsuario(this.tipoUsuario);
        usuario.setActivo(this.activo);
        usuario.setVerificado(this.verificado);
        usuario.setFechaRegistro(this.fechaRegistro);
        usuario.setFechaUltimoAcceso(this.fechaUltimoAcceso);
        usuario.setAceptarTerminos(this.aceptarTerminos);
        usuario.setPrimerIngreso(this.primerIngreso);
        return usuario;
    }

    public static UsuarioDTO fromEntity(UsuarioEntity usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setContrasenaHash(usuario.getContrasenaHash());
        usuarioDTO.setCargo(usuario.getCargo());
        usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
        usuarioDTO.setActivo(usuario.getActivo());
        usuarioDTO.setVerificado(usuario.getVerificado());
        usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
        usuarioDTO.setFechaUltimoAcceso(usuario.getFechaUltimoAcceso());
        usuarioDTO.setAceptarTerminos(usuario.getAceptarTerminos());
        usuarioDTO.setPrimerIngreso(usuario.getPrimerIngreso());
        return usuarioDTO;
    }
}