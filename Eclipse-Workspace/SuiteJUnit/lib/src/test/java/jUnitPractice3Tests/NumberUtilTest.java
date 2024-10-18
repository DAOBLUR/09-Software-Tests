package jUnitPractice3Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import jUnitPractice3.NumberUtil;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilTest {

	@ParameterizedTest(name = "{index} => {0}; {1}")
	@CsvFileSource(resources = "/jUnitPractice3TestsR/testFactorial.csv", numLinesToSkip = 1, delimiter = ';')
    public void testFactorial(int expected, int p1) {
        assertEquals(expected, NumberUtil.factorial(p1));
        assertThrows(IllegalArgumentException.class, () -> NumberUtil.factorial(-p1));
        
    }

	@ParameterizedTest(name = "{index} => {0}; {1}")
	@CsvFileSource(resources = "/jUnitPractice3TestsR/testIsPerfectSquare.csv", numLinesToSkip = 1, delimiter = ';')
    public void testIsPerfectSquare(boolean expected, int p1) {
		assertEquals(expected, NumberUtil.isPerfectSquare(p1));
    }

	@ParameterizedTest(name = "{index} => {0}; {1}")
	@CsvFileSource(resources = "/jUnitPractice3TestsR/testIsFibonacciNumber.csv", numLinesToSkip = 1, delimiter = ';')
    public void testIsFibonacciNumber(boolean expected, int p1) {
		assertEquals(expected, NumberUtil.isFibonacciNumber(p1));
    }

	@ParameterizedTest(name = "{index} => {0}; {1}")
	@CsvFileSource(resources = "/jUnitPractice3TestsR/testIsPalindrome.csv", numLinesToSkip = 1, delimiter = ';')
    public void testIsPalindrome(boolean expected, int p1) {
		assertEquals(expected, NumberUtil.isPalindrome(p1));
        assertThrows(IllegalArgumentException.class, () -> NumberUtil.isPalindrome(-p1));
    }
}