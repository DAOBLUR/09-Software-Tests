package _SuiteJUnit;

import _ExceptionsPackage.CharRunTimeException;

public class Strings {
	public static String Concat(String string1, String string2) {
		if(string1 == null || string2 == null) throw new CharRunTimeException();
        return string1 + string1;
    }

    public static char GetChar(String string, int index) {
    	if(string.length() <= index) throw new CharRunTimeException();
        return string.charAt(index);
    }
}