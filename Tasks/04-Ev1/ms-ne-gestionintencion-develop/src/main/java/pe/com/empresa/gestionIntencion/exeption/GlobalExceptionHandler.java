package pe.com.empresa.gestionIntencion.exeption;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.empresa.gestionIntencion.expose.dto.response.Response;
import pe.com.empresa.gestionIntencion.util.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pe.com.empresa.framework.tracing.exception.NotFoundException;


import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constantes.INTERNAL_SERVER_ERROR_MESSAGE, ex.getMessage()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleResourceNotFoundException(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Response(HttpStatus.BAD_REQUEST.value(), Constantes.BAD_REQUEST_MESSAGE, ex.getMessage()));
    }


    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(org.springframework.validation.FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Response(HttpStatus.BAD_REQUEST.value(), Constantes.BAD_REQUEST_MESSAGE, errorMessage));
    }
}
