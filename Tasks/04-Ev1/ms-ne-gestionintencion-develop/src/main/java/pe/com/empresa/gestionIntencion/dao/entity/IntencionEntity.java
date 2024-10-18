package pe.com.empresa.gestionIntencion.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Intencion", schema = "saip")
public class IntencionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InteId")
    private Integer inteId;

    @Column(name = "InteCantidad", nullable = false)
    private Integer inteCantidad;

    @Column(name = "InteContraparte", length = 150)
    private String inteContraparte;

    @Column(name = "InteComentario", length = 4000)
    private String inteComentario;

    @Column(name = "InteFecRegistro")
    private LocalDateTime inteFecRegistro;

    @Column(name = "InteInstrumento", length = 150)
    private String inteInstrumento;

    @Column(name = "InstId")
    private Integer instId;  // Foreign key

    @Column(name = "UsuaId")
    private Integer usuaId;  // Foreign key

    @Column(name = "DTipOperacion")
    private Integer dTipOperacion;  // Foreign key

    @Column(name = "DRevisado", length = 1)
    private String dRevisado;

    @Column(name = "InteRevComentario", length = 4000)
    private String inteRevComentario;
}
