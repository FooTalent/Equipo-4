package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByCorreo(String correo);
    Optional<UsuarioEntity> findByResetToken(String token);
    List<UsuarioEntity> findByTipoUsuario(Role tipoUsuario);
}
