package jUnitPractice3;

public class NumberUtil {

	/**
     * Calculate factorial N using iteration
     *
     * @param n the number
     * @return the factorial of {@code n}
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        long factorial = 1;
        for (int i = 1; i <= n; factorial *= i, ++i);
        return factorial;
    }
	
	/**
     * Check if a number is perfect square number
     *
     * @param number the number to be checked
     * @return <tt>true</tt> if {@code number} is perfect square, otherwise
     * <tt>false</tt>
     */
    public static boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    /**
     * Check if a number is fibonacci number This is true if and only if at
     * least one of 5x^2+4 or 5x^2-4 is a perfect square
     *
     * @param number the number
     * @return <tt>true</tt> if {@code number} is fibonacci number, otherwise
     * <tt>false</tt>
     * @link https://en.wikipedia.org/wiki/Fibonacci_number#Identification
     */
    public static boolean isFibonacciNumber(int number) {
        return (
            isPerfectSquare(5 * number * number + 4) ||
            isPerfectSquare(5 * number * number - 4)
        );
    }
    
    /**
     * Check if {@code n} is palindrome number or not
     *
     * @param number the number
     * @return {@code true} if {@code n} is palindrome number, otherwise
     * {@code false}
     */
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(number + "");
        }
        int numberCopy = number;
        int reverseNumber = 0;
        while (numberCopy != 0) {
            int remainder = numberCopy % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            numberCopy /= 10;
        }
        return number == reverseNumber;
    }
}