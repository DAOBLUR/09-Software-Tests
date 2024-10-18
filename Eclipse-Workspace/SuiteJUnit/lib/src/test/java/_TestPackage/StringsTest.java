package _TestPackage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import _ExceptionsPackage.CharRunTimeException;
import _SuiteJUnit.Strings;

public class StringsTest {
    @Test
    public void TestConcat() {
    	 assertThrows(CharRunTimeException.class, ()-> Strings.Concat(null,"and"));
    }

    @Test
    public void TestGetChar() { 
        assertThrows(CharRunTimeException.class, ()-> Strings.GetChar(null, 8));
    }
}