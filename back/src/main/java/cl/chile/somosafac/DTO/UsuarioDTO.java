package cl.chile.somosafac.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;


@Data
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

}