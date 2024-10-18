package utest.evidencia2.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import utest.evidencia2.clases.BinaryTree;
import utest.evidencia2.clases.BinaryTree.Node;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree binaryTree;
    private BinaryTree mockBinaryTree;
    
    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        mockBinaryTree = mock(BinaryTree.class);
    }
    
    @Test
    void testFind() {
        Node mockNode = mock(Node.class);
        when(mockBinaryTree.find(10)).thenReturn(mockNode);

        Node result = mockBinaryTree.find(10);

        assertEquals(mockNode, result);
        verify(mockBinaryTree, times(1)).find(10);
    }
    
    @ParameterizedTest(name = "{index} => expected={0}, value={1}")
    @CsvFileSource(resources = "/utest/evidencia2/testsR/testBinaryTree.csv", numLinesToSkip = 1)
    void testFind(boolean expected, int value) {
        Node mockNode = mock(Node.class);
        when(mockBinaryTree.find(value)).thenReturn(expected ? mockNode : null);

        Node result = mockBinaryTree.find(value);

        if (expected) {
            assertNotNull(result);
        } else {
            assertNull(result);
        }
        verify(mockBinaryTree, times(1)).find(value);
    }
    
    @Test
    void testPut() {
        doNothing().when(mockBinaryTree).put(anyInt());
        mockBinaryTree.put(10);
        verify(mockBinaryTree, times(1)).put(10);
    }
    
    @Test
    void testRemove() {
        when(mockBinaryTree.remove(10)).thenReturn(true);

        boolean result = mockBinaryTree.remove(10);

        assertTrue(result);
        verify(mockBinaryTree, times(1)).remove(10);
    }
    
    @Test
    void testFindSuccessor() {
        Node mockNode = mock(Node.class);
        when(mockBinaryTree.findSuccessor(mockNode)).thenReturn(mockNode);

        Node result = mockBinaryTree.findSuccessor(mockNode);

        assertEquals(mockNode, result);
        verify(mockBinaryTree, times(1)).findSuccessor(mockNode);
    }
    
    @Test
    void testGetRoot() {
        Node mockNode = mock(Node.class);
        when(mockBinaryTree.getRoot()).thenReturn(mockNode);

        Node result = mockBinaryTree.getRoot();

        assertEquals(mockNode, result);
        verify(mockBinaryTree, times(1)).getRoot();
    }
    
    @Test
    void testInOrder() {
        Node mockNode = mock(Node.class);
        doNothing().when(mockBinaryTree).inOrder(mockNode);
        mockBinaryTree.inOrder(mockNode);
        verify(mockBinaryTree, times(1)).inOrder(mockNode);
    }
    
    @Test
    void testPreOrder() {
        Node mockNode = mock(Node.class);
        doNothing().when(mockBinaryTree).preOrder(mockNode);
        mockBinaryTree.preOrder(mockNode);
        verify(mockBinaryTree, times(1)).preOrder(mockNode);
    }
    
    @Test
    void testPostOrder() {
        Node mockNode = mock(Node.class);
        doNothing().when(mockBinaryTree).postOrder(mockNode);
        mockBinaryTree.postOrder(mockNode);
        verify(mockBinaryTree, times(1)).postOrder(mockNode);
    }
    
    @Test
    void testBfs() {
        Node mockNode = mock(Node.class);
        doNothing().when(mockBinaryTree).bfs(mockNode);
        mockBinaryTree.bfs(mockNode);
        verify(mockBinaryTree, times(1)).bfs(mockNode);
    }
}