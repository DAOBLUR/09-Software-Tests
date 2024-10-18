package _ParamTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import _DataStructure.Matriz;

public class MatrixTest {
	@ParameterizedTest(name = "{index} =>  {0}, {1}, {2}, {3} => {4}")
	@CsvFileSource(resources = "/dataTesting2.csv", numLinesToSkip = 1, delimiter = ',')
	void DeterminanteTest(double i1, double i2, double i3, double i4, double expected) {
		double[][] elementos = new double[][] {{i1, i2}, {i3, i4}};
		Matriz matrix = new Matriz(elementos);
	    double output = matrix.determinante();
	    assertEquals(expected, output);
	}
	
	@Test
	void ProductoTest() {
		double[][] elementos = new double[][] {{1.0, 2.0}, {4.0, -5.0}};
		Matriz matrix = new Matriz(elementos);
		Matriz output = matrix.producto(-9);
		//Matriz.imprime(output.elementos);
		
		double[][] expected = new double[][] {{-9.0, -18.0}, {-36.0, 45.0}};
		assertArrayEquals(expected, output.elementos);
	}
	
	@Test
	void TranspuestaTest() {
		double[][] elementos = new double[][] {{1, 2}, {4, -5}};
		Matriz matrix = new Matriz(elementos);
		Matriz output = matrix.transpuesta();
		//Matriz.imprime(output.elementos);
		
		double[][] expected = new double[][] {{1, 4}, {2, -5}};
		assertArrayEquals(expected, output.elementos);
	}
	
	@Test
	void OpuestaTest() {
		double[][] elementos = new double[][] {{1, 20}, {4, -5}};
		Matriz matrix = new Matriz(elementos);
		Matriz output = matrix.opuesta();
		//Matriz.imprime(output.elementos);
		
		double[][] expected = new double[][] {{-1, -20}, {-4, 5}};
		assertArrayEquals(expected, output.elementos);
	}
	
	@Test
	void ComplementariaTest() {
		double[][] elementos = new double[][] {};
		Matriz matrix = new Matriz(elementos);
		Matriz output = matrix.complementaria(4,5);
		//Matriz.imprime(output.elementos);
		
		double[][] expected = new double[][] {};
		assertArrayEquals(expected, output.elementos);
	}
}