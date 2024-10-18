package pe.com.empresa.gestionIntencion.util;

public class Constantes {
    // Mensajes para respuestas HTTP exitosas
    public static final String SUCCESS_MESSAGE = "Operación realizada con éxito";
    public static final String CREATED_MESSAGE = "Recurso creado con éxito";
    public static final String UPDATED_MESSAGE = "Recurso actualizado con éxito";
    public static final String DELETED_MESSAGE = "Recurso eliminado con éxito";

    // Mensajes para respuestas HTTP de error
    public static final String RESOURCE_NOT_FOUND_MESSAGE = "Recurso no encontrado";
    public static final String INVALID_REQUEST_MESSAGE = "La solicitud es inválida";
    public static final String BAD_REQUEST_MESSAGE = "La solicitud es inválida. Por favor, revisa los datos e inténtalo de nuevo.";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Ocurrió un error interno en el servidor";
    public static final String UNAUTHORIZED_MESSAGE = "No autorizado";
    public static final String FORBIDDEN_MESSAGE = "Acceso denegado";

    private Constantes() {}
}