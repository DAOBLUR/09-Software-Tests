package footballDBTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import footballDB.Player;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import org.junit.jupiter.api.parallel.ExecutionMode;

public class PlayerTest {
	
	@ParameterizedTest(name = "{index} => {0} => {1}")
	@CsvFileSource(resources = "/FootballDBTest2.csv", numLinesToSkip = 1, delimiter = ',')
	@Execution(ExecutionMode.CONCURRENT)
    public void GetPlayerNameTest(int id, String name) 
	{	
		System.out.println("GetPlayerNameTest: " + id);
        
		String url = "http://localhost:7000/FootballWeb/rs/FootballEJB/GetPlayerName?id=" + id;
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Response response = base.request(MediaType.APPLICATION_JSON).get();
		String result = response.readEntity(String.class);
		
		assertEquals(name, result);
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}, {4} => {5}")
	@CsvFileSource(resources = "/FootballDBTest.csv", numLinesToSkip = 1, delimiter = ',')
	@Execution(ExecutionMode.CONCURRENT)
    public void AddPlayerTest(int id, String firstName, String lastName, int clubId, String nationality, String expected) 
	{	
		System.out.println("AddPlayerTest: " + id);
        
		Player newPlayer = new Player();
        newPlayer.setId(id);
        newPlayer.setClubid(clubId);
        newPlayer.setFirstname(firstName);
        newPlayer.setLastname(lastName);
        newPlayer.setNationality(nationality);

        String url = "http://localhost:7000/FootballWeb/rs/FootballEJB/AddPlayer";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url);

        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(newPlayer, MediaType.APPLICATION_JSON));
       
        String result = response.readEntity(String.class);

        client.close();
		
		assertEquals(expected, result);
    }
}