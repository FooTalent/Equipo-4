package cl.chile.somosafac.entity;

import cl.chile.somosafac.security.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasena_hash", nullable = false)
    private String contrasenaHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private Role tipoUsuario;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean activo;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean verificado;

    @Column(name = "fecha_ultimo_acceso")
    private LocalDateTime fechaUltimoAcceso;

    @Column(name = "aceptar_terminos", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean aceptarTerminos;

    @Column(name = "primer_ingreso", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean primerIngreso;

    // TOKEN PARA RECUPERAR CONTRASENA
    private String resetToken;
    private LocalDateTime fechaExpiracionResetToken;

    @PrePersist
    public void prePersist() {
        if(aceptarTerminos == null){
            aceptarTerminos = false;
        }
        if (verificado == null) {
            verificado = false;
        }
        if(activo == null) {
            activo = true;
        }
        if(primerIngreso == null) {
            primerIngreso = true;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((tipoUsuario.name())));
    }

    @Override
    public String getPassword() {
        return contrasenaHash;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

