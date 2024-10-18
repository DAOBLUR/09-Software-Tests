package pe.com.empresa.gestionIntencion.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.empresa.gestionIntencion.dao.entity.InstrumentoEntity;

import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<InstrumentoEntity, Long> {

    List<InstrumentoEntity> findByInstDescripcion(String instDescripcion);
}
