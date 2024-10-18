package pe.com.empresa.gestionIntencion.expose.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private int status;
    private String message;
    private T data;
}
