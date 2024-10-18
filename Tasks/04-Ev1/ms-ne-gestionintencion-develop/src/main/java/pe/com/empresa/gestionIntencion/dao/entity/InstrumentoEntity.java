package pe.com.empresa.gestionIntencion.dao.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity()
@Table(name = "Instrumento", schema = "saip")
public class InstrumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InstId")
    private Integer instId;

    @Column(name = "InstIsin", length = 150)
    private String instIsin;

    @Column(name = "InstDescripcion", length = 150)
    private String instDescripcion;

    @Column(name = "InstNemonico", length = 150)
    private String instNemonico;

    @Column(name = "InstFecIngreso")
    private LocalDateTime instFecIngreso;

    @Column(name = "InstFecUltModificacion")
    private LocalDateTime instFecUltModificacion;

    @Column(name = "InstEmisor", length = 150)
    private String instEmisor;

    @Column(name = "UsuaIdIngreso")
    private Integer usuaIdIngreso;

    @Column(name = "UsuaIdModifico")
    private Integer usuaIdModifico;

    @Column(name = "InstFondo", length = 150)
    private String instFondo;

    @Column(name = "InstSubFondo", length = 150)
    private String instSubFondo;
}
