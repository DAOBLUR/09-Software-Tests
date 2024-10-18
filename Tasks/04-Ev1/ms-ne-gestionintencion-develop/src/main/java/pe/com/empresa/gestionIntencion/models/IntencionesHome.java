package pe.com.empresa.gestionIntencion.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntencionesHome {
    private Integer intencionId;
    private Integer intencionCantidad;
    private String intencionContraparte;
    private String intencionComentario;
    private Date intencionFecRegistro;
    private Integer usuarioId;
    private Integer intrumentoId;
    private Integer intencionTipoOperacion;
    private String personaNombres;
    private String nombreOperacion;
    private String intencionInstrumento;
    private String intencionRevisado;
    private String intencionRevisadoComentario;
}
