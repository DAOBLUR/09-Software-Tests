package parallelDataStructureTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import parallelDataStructure.Grafo;

public class GrafoTest 
{
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 10, 10, 20, 20, 50, 50, 100, 100 })
    public void ToStringTest(int n) 
	{
		Grafo expectedGrafo = new Grafo(n);
		Grafo testGrafo = new Grafo(n);
		
		for(int i = 0; i < n - 1; i++) 
		{
			expectedGrafo.agregarArista(i, n - 1);
		}
		
		IntStream.range(0, n - 1).parallel().forEach((i) -> 
		{
			testGrafo.agregarArista(i, n - 1);
		});
		
		assertEquals(expectedGrafo.toString(), testGrafo.toString());
    }
	
	@ParameterizedTest
	@ValueSource(ints = { 10, 20, 30, 50, 100, 100, 200, 200, 500, 500, 1000, 1000 })
    public void LengthTest(int n) 
	{
		Grafo expectedGrafo = new Grafo(n);
		Grafo testGrafo = new Grafo(n);
		
		for(int i = 0; i < n - 1; i++) 
		{
			testGrafo.agregarArista(i, n - 1);
		}
		
		IntStream.range(0, n - 1).parallel().forEach((i) -> 
		{
			expectedGrafo.agregarArista(i, n - 1);
		});
		
		assertEquals(expectedGrafo.ObtenerLargo(n-1), testGrafo.ObtenerLargo(n-1));
    }
}