package pe.com.empresa.gestionIntencion.expose.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarIntenciones {
     public int status;
     public String message;
     public List<IntencionesHome> data;
}
