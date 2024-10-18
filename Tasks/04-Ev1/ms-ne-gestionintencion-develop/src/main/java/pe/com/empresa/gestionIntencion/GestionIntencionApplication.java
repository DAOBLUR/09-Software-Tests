package pe.com.empresa.gestionIntencion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pe.com.empresa.gestionIntencion")
public class GestionIntencionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionIntencionApplication.class, args);
	}

}
