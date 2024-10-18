package pe.com.empresa.gestionIntencion.expose;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.empresa.gestionIntencion.busines.IntencionesService;

import pe.com.empresa.gestionIntencion.expose.dto.request.IntencioneRevDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.ListadoIntencionesDto;
import pe.com.empresa.gestionIntencion.expose.dto.response.ListarIntenciones;
import pe.com.empresa.gestionIntencion.expose.dto.response.Response;
import pe.com.empresa.gestionIntencion.util.Constantes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.empresa.framework.tracing.filter.operation.annotation.AuditLogging;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesUpdDto;

import javax.validation.Valid;

@Log4j
@RestController
@RequestMapping(value = "/v1/intenciones")
public class IntencionesController {

    @Autowired
    private IntencionesService intencionesService;

    @GetMapping(value = "home")
    public ResponseEntity<String> listado()  {
        return ResponseEntity.status(HttpStatus.OK).body("hola mundo - gestionIntencion");
    }

    @AuditLogging(enabled = true, functionalAction = "listado de intenciones")
    @GetMapping(produces = "application/json")
    public ResponseEntity<ListarIntenciones> listado(@ModelAttribute ListadoIntencionesDto request) {
        var elemento = this.intencionesService.listadoIntenciones(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ListarIntenciones(HttpStatus.OK.value(), Constantes.SUCCESS_MESSAGE, elemento));

    }

    @AuditLogging(enabled = true, functionalAction = "registro de intenciones")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> registroIntenciones(@Valid @RequestBody IntencionesDto request) {

        var intenciones = this.intencionesService.registroIntenciones(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Response(HttpStatus.CREATED.value(), Constantes.CREATED_MESSAGE, intenciones.toString()));
    }

    @AuditLogging(enabled = true, functionalAction = "Actualizar intención")
    @PutMapping( produces = "application/json")
    public ResponseEntity<Response> actualizarIntenciones(@RequestBody IntencionesUpdDto intencionesUpdRequest) {
        System.out.println("*********************** actualizarIntenciones");
        IntencionesUpdDto intenciones = this.intencionesService.actualizarIntenciones(intencionesUpdRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(HttpStatus.OK.value(), Constantes.UPDATED_MESSAGE, intenciones.toString()));
    }

    @AuditLogging(enabled = true, functionalAction = "Eliminar intención")
    @DeleteMapping(value = "/{intencionId}", produces = "application/json")
    public ResponseEntity<Response> eliminarIntenciones(@PathVariable("intencionId") Integer intencionId) {

        String message =  this.intencionesService.eliminarIntenciones(intencionId);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(HttpStatus.OK.value(), message, null));
    }

    @PutMapping(value = "/revisado", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> actualizarRevisadoIntenciones(@RequestBody IntencioneRevDto intencion) {
        var intention = this.intencionesService.actualizarRevisadoIntencion(intencion);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(HttpStatus.OK.value(), Constantes.UPDATED_MESSAGE, intention));
    }
}
