package pe.com.empresa.gestionIntencion.expose.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntencionesUpdDto {
    private int intencionId;
    private int intecionCantidad;
    private String intencionContraparte;
    private String intencionComentario;
    private int tipoOperacion;
    private String inteInstrumento;
}
