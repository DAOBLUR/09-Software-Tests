package pe.com.empresa.gestionIntencion.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.empresa.gestionIntencion.dao.entity.IntencionListEntity;

import java.util.List;

@Repository
public interface IntencionListaRepository extends JpaRepository<IntencionListEntity, Integer> {

    @Query(name = "IntencionListEntity.findAll", nativeQuery = true)
    List<IntencionListEntity> executeInteSsAll(
            @Param("InteInstrumento") String InteInstrumento,
            @Param("DTipOperacion") Integer DTipOperacion,
            @Param("PersNomCompleto") String PersNomCompleto,
            @Param("UsuaId") String UsuaId,
            @Param("DTipTipoUsuario") Integer DTipTipoUsuario,
            @Param("DRevisado") String DRevisado
    );
}
