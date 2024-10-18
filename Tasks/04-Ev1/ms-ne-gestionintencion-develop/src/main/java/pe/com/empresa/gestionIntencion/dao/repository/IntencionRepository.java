package pe.com.empresa.gestionIntencion.dao.repository;

import pe.com.empresa.gestionIntencion.dao.entity.IntencionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IntencionRepository extends JpaRepository<IntencionEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "EXEC [saip].[InteSi] :InteCantidad, :InteContraparte, :InteComentario, :DTipOperacion, :UsuaId, :InstId, :InteInstrumento", nativeQuery = true)
    Integer executeInteSave(
            @Param("InteCantidad") Integer InteCantidad,
            @Param("InteContraparte") String InteContraparte,
            @Param("InteComentario") String InteComentario,
            @Param("DTipOperacion") Integer DTipOperacion,
            @Param("UsuaId") Integer UsuaId,
            @Param("InstId") Integer InstId,
            @Param("InteInstrumento") String InteInstrumento
    );

    @Modifying
    @Transactional
    @Query(value = "EXEC [saip].[InteSu] :InteId, :InteCantidad, :InteContraparte, :InteComentario, :DTipOperacion, :InteInstrumento", nativeQuery = true)
    void executeUpdateIntencion(
            @Param("InteId") int InteId,
            @Param("InteCantidad") int InteCantidad,
            @Param("InteContraparte") String InteContraparte,
            @Param("InteComentario") String InteComentario,
            @Param("DTipOperacion") int DTipOperacion,
            @Param("InteInstrumento") String InteInstrumento
    );

    @Modifying
    @Transactional
    @Query(value = "EXEC [saip].[InteSd] :InteId", nativeQuery = true)
    void executeDeleteIntencion(@Param("InteId") int InteId);
}