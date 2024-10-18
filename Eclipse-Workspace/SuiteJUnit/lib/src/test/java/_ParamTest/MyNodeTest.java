package _ParamTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import _DataStructure.MyNode;;

public class MyNodeTest {
	@ParameterizedTest(name = "{index} =>  {0} {1} {2} {3} {4} => {5}")
	@CsvFileSource(resources = "/datatesting1.csv", numLinesToSkip = 1, delimiter = ',')
	void LargestElementTest(int i1, int i2, int i3, int i4, int i5, int expected) {
		MyNode.head = null;
	    MyNode.push(i1);
	    MyNode.push(i2);
	    MyNode.push(i2);
	    MyNode.push(i4);
	    MyNode.push(i5);
	    int output = MyNode.largestElement(MyNode.head); 
	    assertEquals(expected, output);
	}
	
	@Test
	void SmallestElementTest() {
		MyNode.head = null;
	    MyNode.push(-5);
	    MyNode.push(-8);
	    MyNode.push(-10);
	    MyNode.push(150);
	    MyNode.push(66);
	    int output = MyNode.smallestElement(MyNode.head); 
	    assertEquals(-10, output);
	}
}