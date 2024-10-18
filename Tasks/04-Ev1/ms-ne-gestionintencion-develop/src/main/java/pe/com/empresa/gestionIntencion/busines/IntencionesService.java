package pe.com.empresa.gestionIntencion.busines;


import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencioneRevDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesUpdDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.ListadoIntencionesDto;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;

import java.util.List;

public interface IntencionesService {
    List<IntencionesHome> listadoIntenciones(ListadoIntencionesDto request);
    IntencionesDto registroIntenciones(IntencionesDto intencionesRequest);
    IntencionesUpdDto actualizarIntenciones(IntencionesUpdDto intencionesUpdRequest);
    String eliminarIntenciones(Integer id);
    IntencioneRevDto actualizarRevisadoIntencion(IntencioneRevDto request);
}
