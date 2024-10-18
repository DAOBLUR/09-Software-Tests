package pe.com.empresa.gestionIntencion.expose.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntencioneRevDto {
    private Integer intencionId;
    private String comentario;
    private String revisado;
}
