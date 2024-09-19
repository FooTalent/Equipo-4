package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.VoluntarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<VoluntarioEntity, Long> {
}
