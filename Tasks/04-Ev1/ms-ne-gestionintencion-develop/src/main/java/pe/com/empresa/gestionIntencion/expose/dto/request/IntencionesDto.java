package pe.com.empresa.gestionIntencion.expose.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IntencionesDto {
    @NotNull(message = "La cantidad es requerida")
    @Min(value = 1, message = "La cantidad debe ser un número positivo mayor que cero")
    private Integer intencionCantidad;

    @NotBlank(message = "La contraparte es requerida")
    private String intencionContraparte;

    @NotBlank(message = "El comentario es requerido")
    private String intencionComentario;

    @NotNull(message = "El tipo de operación es requerido")
    @Min(value = 1, message = "El tipo de operación debe ser un número positivo mayor que cero")
    private Integer tipoOperacion;

    @NotNull(message = "El ID de usuario es requerido")
    @Min(value = 1, message = "El ID de usuario debe ser un número positivo mayor que cero")
    private Integer usuarioId;

    @NotNull(message = "El ID de instrumento es requerido")
    @Min(value = 1, message = "El ID de instrumento debe ser un número positivo mayor que cero")
    private Integer instrumentoId;

    @NotBlank(message = "El nombre del instrumento es requerido")
    private String inteInstrumento;
}
