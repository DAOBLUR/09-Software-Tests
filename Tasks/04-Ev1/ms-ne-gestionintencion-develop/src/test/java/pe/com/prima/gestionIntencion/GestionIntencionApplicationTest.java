package pe.com.prima.gestionIntencion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pe.com.empresa.gestionIntencion.busines.IntencionesService;
import pe.com.empresa.gestionIntencion.expose.IntencionesController;
import pe.com.empresa.gestionIntencion.expose.dto.request.ListadoIntencionesDto;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

@WebMvcTest(IntencionesController.class)
class GestionIntencionApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IntencionesService intencionesService;

	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/v1/intenciones/home"))
				.andExpect(status().isOk())
				.andExpect(content().string("hola mundo - gestionIntencion"));
	}
	
	//TO DO
	@Test
    void listadoIntensionesTest() throws Exception {
    	var intencionesService1 = mock(IntencionesService.class);
    	var intensionesHomeList = new ArrayList<IntencionesHome>();
    	intensionesHomeList.add(new IntencionesHome());
    	
    	when(intencionesService1.listadoIntenciones(any())).thenReturn(intensionesHomeList);
    	assertNotNull(intencionesService1.listadoIntenciones(new ListadoIntencionesDto()));	
    }
}
