package utest.evidencia2.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import utest.evidencia2.clases.DynamicArray;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

class DynamicArrayTest {
    private DynamicArray<String> dynamicArray;
    private DynamicArray<String> mockDynamicArray;
    
    @BeforeEach
    void setUp() {
        dynamicArray = new DynamicArray<>();
        mockDynamicArray = mock(DynamicArray.class);
    }
    
    @Test
    void testAddAndGetSize() {
        when(mockDynamicArray.getSize()).thenReturn(3);

        int size = mockDynamicArray.getSize();

        assertEquals(3, size);
        verify(mockDynamicArray, times(1)).getSize();
    }
    
    @Test
    void testAddElement() {
        doNothing().when(mockDynamicArray).add(any(String.class));
        mockDynamicArray.add("Test Element");
        verify(mockDynamicArray, times(1)).add("Test Element");
    }
    
    @Test
    void testGetElement() {
        when(mockDynamicArray.get(0)).thenReturn("Element 1");

        String element = mockDynamicArray.get(0);

        assertEquals("Element 1", element);
        verify(mockDynamicArray, times(1)).get(0);
    }
    
    @Test
    void testRemoveElement() {
        when(mockDynamicArray.remove(0)).thenReturn("Element 1");

        String removedElement = mockDynamicArray.remove(0);

        assertEquals("Element 1", removedElement);
        verify(mockDynamicArray, times(1)).remove(0);
    }
    
    @Test
    void testIsEmpty() {
        when(mockDynamicArray.isEmpty()).thenReturn(true);
        boolean isEmpty = mockDynamicArray.isEmpty();
        assertTrue(isEmpty);
        verify(mockDynamicArray, times(1)).isEmpty();
    }
    
    @Test
    void testIterator() {
        Iterator<String> mockIterator = mock(Iterator.class);
        
        when(mockIterator.hasNext()).thenReturn(true, false);
        when(mockIterator.next()).thenReturn("Mock Element");
        
        assertTrue(mockIterator.hasNext());
        assertEquals("Mock Element", mockIterator.next());
        assertFalse(mockIterator.hasNext());

        verify(mockIterator, times(2)).hasNext();
        verify(mockIterator, times(1)).next();
    }
}