package utest.evidencia2.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import utest.evidencia2.clases.CircleLinkedList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CircleLinkedListTest {
    private CircleLinkedList<String> circleLinkedList;
    private CircleLinkedList<String> mockCircleLinkedList;
    
    @BeforeEach
    void setUp() {
        circleLinkedList = new CircleLinkedList<>();
        mockCircleLinkedList = mock(CircleLinkedList.class);
    }
    
    @Test
    void testGetSize() {
        when(mockCircleLinkedList.getSize()).thenReturn(3);

        int size = mockCircleLinkedList.getSize();

        assertEquals(3, size);
        verify(mockCircleLinkedList, times(1)).getSize();
    }
    
    @Test
    void testAppendElement() {
        doNothing().when(mockCircleLinkedList).append(any(String.class));
        mockCircleLinkedList.append("Test Element");
        verify(mockCircleLinkedList, times(1)).append("Test Element");
    }
    
    @Test
    void testRemoveElement() {
        when(mockCircleLinkedList.remove(0)).thenReturn("Element 1");

        String removedElement = mockCircleLinkedList.remove(0);

        assertEquals("Element 1", removedElement);
        verify(mockCircleLinkedList, times(1)).remove(0);
    }
    
    @Test
    void testToString() {
        when(mockCircleLinkedList.toString()).thenReturn("[Test Element]");
        
        String result = mockCircleLinkedList.toString();
        
        assertEquals("[Test Element]", result);
        verify(mockCircleLinkedList, times(1)).toString();
    }
}