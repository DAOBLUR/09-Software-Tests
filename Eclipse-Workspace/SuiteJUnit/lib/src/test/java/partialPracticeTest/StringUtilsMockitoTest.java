package partialPracticeTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;

import partialPractice.StringUtils;

public class StringUtilsMockitoTest {

	@Mock
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = mock(StringUtils.class);
    }

    @ParameterizedTest(name = "{index} => str={0}, maxWidth={1}, expected={2}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/abbreviate01.csv", numLinesToSkip = 1)
    void testAbbreviate(final String str, final int maxWidth, String expected) {
    	when(stringUtils.abbreviate(str, maxWidth)).thenReturn(expected);
        String result = stringUtils.abbreviate(str, maxWidth);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).abbreviate(str, maxWidth);
    }

    @ParameterizedTest(name = "{index} => str={0}, offset={1}, maxWidth={2}, expected={3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/abbreviate02.csv", numLinesToSkip = 1)
    void testAbbreviate(final String str, final int offset, final int maxWidth, String expected) {
    	when(stringUtils.abbreviate(str, offset, maxWidth)).thenReturn(expected);
        String result = stringUtils.abbreviate(str, offset, maxWidth);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).abbreviate(str, offset, maxWidth);
    }
    
    @ParameterizedTest(name = "{index} => str={0}, abbrevMarker={1}, maxWidth={2}, expected={3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/abbreviate03.csv", numLinesToSkip = 1)
    void testAbbreviate(final String str, final String abbrevMarker, final int maxWidth, String expected) {
    	when(stringUtils.abbreviate(str, abbrevMarker, maxWidth)).thenReturn(expected);
        String result = stringUtils.abbreviate(str, abbrevMarker, maxWidth);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).abbreviate(str, abbrevMarker, maxWidth);
    }
    
    @ParameterizedTest(name = "{index} => str={0}, abbrevMarker={1}, offset={2}, maxWidth={3}, expected={4}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/abbreviate04.csv", numLinesToSkip = 1)
    void testAbbreviate(final String str, final String abbrevMarker, int offset, final int maxWidth, String expected) {
    	when(stringUtils.abbreviate(str, abbrevMarker, offset, maxWidth)).thenReturn(expected);
        String result = stringUtils.abbreviate(str, abbrevMarker, offset, maxWidth);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).abbreviate(str, abbrevMarker, offset, maxWidth);
    }
    
    @ParameterizedTest(name = "{index} => str={0}, middle={1}, length={2}, expected={3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/abbreviateMiddle.csv", numLinesToSkip = 1)
    void testAbbreviateMiddle(final String str, final String middle, final int length, String expected) {
    	when(stringUtils.abbreviateMiddle(str, middle, length)).thenReturn(expected);
        String result = stringUtils.abbreviateMiddle(str, middle, length);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).abbreviateMiddle(str, middle, length);
    }
    
    @ParameterizedTest(name = "{index} => str={0}, suffix={1}, suffixes={2}, expected={3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/appendIfMissing.csv", numLinesToSkip = 1)
    void testAppendIfMissing(final String str, final CharSequence suffix, final CharSequence suffixes, String expected) {
    	when(stringUtils.appendIfMissing(str, suffix, suffixes)).thenReturn(expected);
        String result = stringUtils.appendIfMissing(str, suffix, suffixes);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).appendIfMissing(str, suffix, suffixes);
    }

    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/capitalize.csv", numLinesToSkip = 1)
    void testcapitalize(final String str, String expected) {
    	when(stringUtils.capitalize(str)).thenReturn(expected);
        String result = stringUtils.capitalize(str);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).capitalize(str);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/center.csv", numLinesToSkip = 1)
    void testcenter(final String str, final int size, String expected) {
    	when(stringUtils.center(str, size)).thenReturn(expected);
        String result = stringUtils.center(str, size);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).center(str, size);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/chomp.csv", numLinesToSkip = 1)
    void testchomp(final String str, String expected) {
    	when(stringUtils.chomp(str)).thenReturn(expected);
        String result = stringUtils.chomp(str);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).chomp(str);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/chop.csv", numLinesToSkip = 1)
    void testchop(final String str, String expected) {
    	when(stringUtils.chop(str)).thenReturn(expected);
        String result = stringUtils.chop(str);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).chop(str);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/compare.csv", numLinesToSkip = 1)
    void testcompare(final String str1, final String str2, int expected) {
    	when(stringUtils.compare2(str1,str2)).thenReturn(expected);
        var result = stringUtils.compare2(str1,str2);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).compare2(str1,str2);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/contains.csv", numLinesToSkip = 1)
    void testcontains(final CharSequence seq, final CharSequence searchSeq, boolean expected) {
    	when(stringUtils.contains2(seq,searchSeq)).thenReturn(expected);
        var result = stringUtils.contains2(seq,searchSeq);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).contains2(seq,searchSeq);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/defaultIfBlank.csv", numLinesToSkip = 1)
    void testdefaultIfBlank(final String str, final String defaultStr, String expected) {
    	when(stringUtils.defaultIfBlank(str,defaultStr)).thenReturn(expected);
        var result = stringUtils.defaultIfBlank(str,defaultStr);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).defaultIfBlank(str,defaultStr);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/deleteWhitespace.csv", numLinesToSkip = 1)
    void testdeleteWhitespace(final String str, String expected) {
    	when(stringUtils.deleteWhitespace(str)).thenReturn(expected);
        var result = stringUtils.deleteWhitespace(str);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).deleteWhitespace(str);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/difference.csv", numLinesToSkip = 1)
    void testdifference(final String str1, final String str2, String expected) {
    	when(stringUtils.difference(str1, str2)).thenReturn(expected);
        var result = stringUtils.difference(str1, str2);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).difference(str1, str2);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/endsWith.csv", numLinesToSkip = 1)
    void testendsWith(final CharSequence str, final CharSequence suffix, boolean expected) {
    	when(stringUtils.endsWith2(str, suffix)).thenReturn(expected);
        var result = stringUtils.endsWith2(str, suffix);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).endsWith2(str, suffix);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/equals.csv", numLinesToSkip = 1)
    void testequals(final CharSequence cs1, final CharSequence cs2, boolean expected) {
    	when(stringUtils.equals2(cs1, cs2)).thenReturn(expected);
        var result = stringUtils.equals2(cs1, cs2);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).equals2(cs1, cs2);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/firstNonEmpty.csv", numLinesToSkip = 1)
    void testfirstNonEmpty(String expected, final String... values) {
    	when(stringUtils.firstNonEmpty2(values)).thenReturn(expected);
        var result = stringUtils.firstNonEmpty2(values);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).firstNonEmpty2(values);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/getDigits.csv", numLinesToSkip = 1)
    void testgetDigits(final String str, final String expected) {
    	when(stringUtils.getDigits(str)).thenReturn(expected);
        var result = stringUtils.getDigits(str);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).getDigits(str);
    }
    
    @ParameterizedTest(name = "{index} => {0}, {1}, {2}, {3}")
    @CsvFileSource(resources = "/StringUtilsMockitoTestR/indexOf.csv", numLinesToSkip = 1)
    void testindexOf(final CharSequence seq, final CharSequence searchSeq, final int expected) {
    	when(stringUtils.indexOf(seq,searchSeq)).thenReturn(expected);
        var result = stringUtils.indexOf(seq,searchSeq);
        
        assertEquals(expected, result);
        verify(stringUtils, times(1)).indexOf(seq,searchSeq);
    }
}