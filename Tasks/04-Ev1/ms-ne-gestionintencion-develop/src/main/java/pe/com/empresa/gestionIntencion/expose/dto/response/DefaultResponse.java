package pe.com.empresa.gestionIntencion.expose.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse {
    private int status;
    private String message;
    private String data;
}
