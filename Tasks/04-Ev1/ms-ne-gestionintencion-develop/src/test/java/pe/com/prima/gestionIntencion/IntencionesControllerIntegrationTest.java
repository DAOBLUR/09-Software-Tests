package pe.com.prima.gestionIntencion;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pe.com.empresa.gestionIntencion.busines.IntencionesService;
import pe.com.empresa.gestionIntencion.dao.entity.IntencionEntity;
import pe.com.empresa.gestionIntencion.dao.repository.IntencionRepository;
import pe.com.empresa.gestionIntencion.dao.repository.InstrumentoRepository;
import pe.com.empresa.gestionIntencion.expose.IntencionesController;
import pe.com.empresa.gestionIntencion.expose.dto.request.ListadoIntencionesDto;
import pe.com.empresa.gestionIntencion.expose.dto.response.ListarIntenciones;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;
import pe.com.empresa.gestionIntencion.util.Constantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IntencionesController.class)
class IntencionesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IntencionesService intencionesService;

    @MockBean
    private IntencionRepository intencionesRepository;

    @MockBean
    private InstrumentoRepository validarInstrumentoEntity;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;
	
	//TO DO
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	//TO DO
    @Test
    void givenValidRequest_whenListarIntenciones_thenReturnsIntenciones() throws Exception {
    	var intensionesHomeList = new ArrayList<IntencionesHome>();
    	var elemento = this.intencionesService.listadoIntenciones(new ListadoIntencionesDto());
    	var listarIntenciones = new ListarIntenciones();
    	listarIntenciones.status = HttpStatus.OK.value();
    	listarIntenciones.message = Constantes.SUCCESS_MESSAGE;
    	listarIntenciones.data = elemento;
    	
    	when(listarIntenciones.thenReturn());
    	assertNotNull(intencionesService1.listadoIntenciones(new ListadoIntencionesDto()));	
    }
}
