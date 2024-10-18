package partialPracticeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import partialPractice.StringUtils;

public class StringUtilsJUnitTest {
	
	@ParameterizedTest(name = "{index} => str={0}, wrapWith={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/wrapIfMissing.csv", numLinesToSkip = 1)
    public void testWrapIfMissing(final String str, final String wrapWith, String expected) {
		assertEquals(expected, StringUtils.wrapIfMissing(str, wrapWith));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, wrapWith={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/wrap.csv", numLinesToSkip = 1)
    public void testWrap(final String str, final String wrapWith, String expected) {
		assertEquals(expected, StringUtils.wrap(str, wrapWith));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, locale={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/upperCase.csv", numLinesToSkip = 1)
    public void testUpperCase(final String str, final Locale locale, String expected) {
		assertEquals(expected, StringUtils.upperCase(str, locale));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, expected={1}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/uncapitalize.csv", numLinesToSkip = 1)
    public void testUncapitalize(final String str, String expected) {
		assertEquals(expected, StringUtils.uncapitalize(str));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, maxWidth={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/truncate.csv", numLinesToSkip = 1)
    public void testTruncate(final String str, final int maxWidth, String expected) {
		if(maxWidth >= 0) {
			assertEquals(expected, StringUtils.truncate(str, maxWidth));
		}
		else {
			assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(str, maxWidth));
		}
    }
	
	@ParameterizedTest(name = "{index} => cs={0}, expected={1}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/toCodePoints.csv", numLinesToSkip = 1)
    public void testToCodePoints(final CharSequence cs, int[] expected) {
		assertEquals(expected, StringUtils.toCodePoints(cs));
    }
	
	@ParameterizedTest(name = "{index} => str1={0}, str2={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/compare.csv", numLinesToSkip = 1)
    public void testCompare(final String str1, final String str2, int expected) {
		assertEquals(expected, StringUtils.compare(str1, str2));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, ch={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/countMatches.csv", numLinesToSkip = 1)
    public void testCountMatches(final CharSequence str, final char ch, int expected) {
		assertEquals(expected, StringUtils.countMatches(str, ch));
    }
	
	@ParameterizedTest(name = "{index} => bytes={0}, charsetName={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/toString.csv", numLinesToSkip = 1)
    public void testToString(final byte[] bytes, final String charsetName, int expected) throws UnsupportedEncodingException {
		assertEquals(expected, StringUtils.toString(bytes, charsetName));
    }
	
	@ParameterizedTest(name = "{index} => bytes={0}, charsetName={1}, expected={2}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/toString.csv", numLinesToSkip = 1)
    public void testToString2(final byte[] bytes, final String charsetName, int expected) {
		assertThrows(UnsupportedEncodingException.class, () -> StringUtils.toString(bytes, charsetName));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, expected={1}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/trimToNull.csv", numLinesToSkip = 1)
    public void testTrimToNull(final String str, String expected) {
		assertEquals(expected, StringUtils.trimToNull(str));
    }
	
	@ParameterizedTest(name = "{index} => str={0}, expected={1}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/trimToEmpty.csv", numLinesToSkip = 1)
    public void testtrimToEmpty(final String str, String expected) {
		assertEquals(expected, StringUtils.trimToEmpty(str));
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/swapCase.csv", numLinesToSkip = 1)
    public void testswapCase(final String str, String expected) {
		assertEquals(expected, StringUtils.swapCase(str));
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/substringsBetween.csv", numLinesToSkip = 1)
    public void testsubstringsBetween(final String str, final String open, final String close, String expected) {
		assertEquals(expected, StringUtils.substringsBetween(str, open, close));
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/substringAfterLast.csv", numLinesToSkip = 1)
    public void testsubstringAfterLast(final String str, final String separator, String expected) {
		assertEquals(expected, StringUtils.substringAfterLast(str, separator));
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/split.csv", numLinesToSkip = 1)
    public void testsplit(final String str, String[] expected) {
		assertEquals(expected, StringUtils.split(str));
    }
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/rotate.csv", numLinesToSkip = 1)
    public void testrotate(final String str, final int shift, String expected) {
		assertEquals(expected, StringUtils.rotate(str,shift));
	}
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/rightPad.csv", numLinesToSkip = 1)
    public void testrightPad(final String str, final int size, String padStr, String expected) {
		assertEquals(expected, StringUtils.rightPad(str,size,padStr));
	}
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/reverseDelimited.csv", numLinesToSkip = 1)
    public void testreverseDelimited(final String str, final char separatorChar, String expected) {
		assertEquals(expected, StringUtils.reverseDelimited(str,separatorChar));
	}
	
	@ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
	@CsvFileSource(resources = "/stringUtilsJUnitTestR/replaceOnceIgnoreCase.csv", numLinesToSkip = 1)
    public void testreplaceOnceIgnoreCase(final String text, final String searchString, final String replacement, String expected) {
		assertEquals(expected, StringUtils.replaceOnceIgnoreCase(text,searchString,replacement));
	}
}



/*
UnsupportedEncodingException importar

static int

private static String toStringOrEmpty(final Object obj) {
	return Objects.toString(obj, EMPTY);
}

 */