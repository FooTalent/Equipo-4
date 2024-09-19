package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.MentoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends JpaRepository<MentoriaEntity, Long> {
}
