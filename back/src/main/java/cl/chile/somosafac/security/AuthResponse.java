package cl.chile.somosafac.security;

import cl.chile.somosafac.DTO.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    @JsonProperty("usuario")
    UsuarioDTO usuarioDTO;
}
