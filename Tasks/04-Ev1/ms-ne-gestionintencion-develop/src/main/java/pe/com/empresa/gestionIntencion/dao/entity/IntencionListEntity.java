package pe.com.empresa.gestionIntencion.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
@SqlResultSetMapping(
        name = "IntencionListEntityMapping",
        entities = @EntityResult(entityClass = IntencionListEntity.class)
)
@NamedNativeQuery(
        name = "IntencionListEntity.findAll",
        query = "EXEC [saip].[InteSsAll] :InteInstrumento, :DTipOperacion, :PersNomCompleto, :UsuaId, :DTipTipoUsuario, :DRevisado",
        resultSetMapping = "IntencionListEntityMapping"
)
public class IntencionListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InteId")
    private Integer inteId;

    @Column(name = "InteCantidad")
    private Integer inteCantidad;

    @Column(name = "InteContraparte")
    private String inteContraparte;

    @Column(name = "InteComentario")
    private String inteComentario;

    @Column(name = "InteFecRegistro")
    private Date inteFecRegistro;

    @Column(name = "UsuaId")
    private Integer usuaId;

    @Column(name = "InstId")
    private Integer instId;

    @Column(name = "DTipOperacion")
    private Integer tipoOperacion;

    @Column(name = "PersNombres")
    private String persNombres;

    @Column(name = "NombreOperacion")
    private String nombreOperacion;

    @Column(name = "InteInstrumento")
    private String inteInstrumento;

    @Column(name = "DRevisado")
    private String revisadoInte;

    @Column(name = "InteRevComentario")
    private String inteRevComentario;
}
