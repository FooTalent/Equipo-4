package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity, Long> {

    @Query("SELECT c FROM ContactoEntity c WHERE c.familia.id = :familiaId")
    List<ContactoEntity> findByFamiliaId(@Param("familiaId") Long familiaId);

    @Query("SELECT c FROM ContactoEntity c WHERE c.usuario.id = :usuarioId")
    List<ContactoEntity> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT c FROM ContactoEntity c WHERE c.familia.id = :familiaId AND c.fechaContacto BETWEEN :fechaInicio AND :fechaFin")
    List<ContactoEntity> findByFamiliaIdAndFechaContactoBetween(@Param("familiaId") Long familiaId, @Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    Optional<ContactoEntity> findByIdAndFamiliaId(Long id, Long familiaId);

    @Query("SELECT c FROM ContactoEntity c WHERE c.fechaContacto IS NULL")
    List<ContactoEntity> findByFechaContactoIsNull();

    List<ContactoEntity> findByFechaContactoBefore(LocalDateTime fechaContacto);

}