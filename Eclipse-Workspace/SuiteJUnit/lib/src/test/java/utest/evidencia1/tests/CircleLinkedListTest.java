package utest.evidencia1.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import utest.evidencia1.clases.CircleLinkedList;

class CircleLinkedListTest {

    @Test
    void testAddElements() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.getSize());
    }

    @Test
    void testRemoveElement() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        
        list.remove(2);
        list.remove(3);
        assertEquals(2, list.getSize());
    }

    @ParameterizedTest(name = "{index} => {0}")
	@CsvFileSource(resources = "/utest/evidencia1/testsResources/datatest02.csv", numLinesToSkip = 1, delimiter = ';')
    void testCicle(String elements) {
    	CircleLinkedList<Integer> list = new CircleLinkedList<>();
    	
    	String[] elementArray = elements.split(",");
        for (String element : elementArray) {
            list.append(Integer.parseInt(element.trim()));
        }
        
        System.out.println(list.toString());

        assertEquals(list.getTail().getNext().getValue(), list.getHead().getValue());
    }
    
    @ParameterizedTest(name = "{index} => {0} -> {1}")
	@CsvFileSource(resources = "/utest/evidencia1/testsResources/datatest01.csv", numLinesToSkip = 1, delimiter = ';')
    void testToString(int size, String expected) {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        
        for(Integer i = 1; i <= size; i++) {
			list.append(i);
		}
        
        String value = list.toString();
        assertEquals(expected, value);
    }
}
