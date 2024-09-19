package cl.chile.somosafac.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String correo;
    private String contrasenaHash;
    private String tipoUsuario;
    private boolean activo;
    private boolean verificado;
    private String fechaRegistro;
    private String fechaUltimoAcceso;
    private boolean aceptarTerminos;
}

