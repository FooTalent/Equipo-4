package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.NotificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<NotificacionEntity, Long> {
}
