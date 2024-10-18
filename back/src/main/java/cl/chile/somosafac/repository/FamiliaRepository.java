package cl.chile.somosafac.repository;

import cl.chile.somosafac.entity.FamiliaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FamiliaRepository extends JpaRepository<FamiliaEntity, Long> {
    List<FamiliaEntity> findByNombreFaUnoContainingIgnoreCase(String nombre);

    @Query("SELECT f FROM FamiliaEntity f WHERE " +
            "(:nombre IS NULL OR f.nombreFaUno LIKE %:nombre%) AND " +
            "(:ciudad IS NULL OR f.comuna LIKE %:comuna%) AND " +
            "(:region IS NULL OR f.region LIKE %:region%)")
    List<FamiliaEntity> searchFamilias(@Param("nombre") String nombre,
                                       @Param("comuna") String comuna,
                                       @Param("region") String region);
}


