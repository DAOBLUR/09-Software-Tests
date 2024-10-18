package pe.com.empresa.gestionIntencion.expose.dto.request;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
public class ListadoIntencionesDto {
    private String instrumento;
    private Integer tipoOperacion;
    private String nombreCompleto;
    private String usuarioId;
    private Integer tipoUsuario;
    private String intencionRevisado;

    @Override
    public String toString() {
        return "ListadoIntencionesDto{" +
                "instrumento='" + instrumento + '\'' +
                ", tipoOperacion=" + tipoOperacion +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", intencionRevisado='" + intencionRevisado + '\'' +
                '}';
    }
}
