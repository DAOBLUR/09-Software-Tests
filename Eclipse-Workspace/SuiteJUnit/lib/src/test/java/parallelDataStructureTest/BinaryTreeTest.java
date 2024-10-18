package parallelDataStructureTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import parallelDataStructure.*;

public class BinaryTreeTest 
{
	static TLNode leftBranch = new TLNode(0);
	static TLNode rightBranch = new TLNode(0);
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 10, 10, 20, 20, 50, 50, 100, 100 })
    public void PreOrderTest(int n) 
	{	
		TLNode expectedRoot = new TLNode(0);
		TLNode testRoot = new TLNode(0);
        
		leftBranch = rightBranch = expectedRoot;
		
		for(int i = 1; i < n; i++) 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		}
		
		leftBranch = rightBranch = testRoot;
		
		IntStream.range(1, n).parallel().forEach((i) -> 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		});  
        
        System.out.println(BinaryTree.PreOrder(expectedRoot));
        System.out.println(BinaryTree.PreOrder(testRoot));
		
        assertEquals(BinaryTree.PreOrder(expectedRoot), BinaryTree.PreOrder(testRoot));
    }
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 10, 10, 20, 20, 50, 50, 100, 100 })
	public void InOrderTest(int n) 
	{	
		TLNode expectedRoot = new TLNode(0);
		TLNode testRoot = new TLNode(0);
        
		leftBranch = rightBranch = expectedRoot;
		
		for(int i = 1; i < n; i++) 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		}
		
		leftBranch = rightBranch = testRoot;
		
		IntStream.range(1, n).parallel().forEach((i) -> 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		});  
        
        System.out.println(BinaryTree.InOrder(expectedRoot));
        System.out.println(BinaryTree.InOrder(testRoot));
		
        assertEquals(BinaryTree.InOrder(expectedRoot), BinaryTree.InOrder(testRoot));
    }
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 10, 10, 20, 20, 50, 50, 100, 100 })
	public void PostOrderTest(int n) 
	{	
		TLNode expectedRoot = new TLNode(0);
		TLNode testRoot = new TLNode(0);
        
		leftBranch = rightBranch = expectedRoot;
		
		for(int i = 1; i < n; i++) 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		}
		
		leftBranch = rightBranch = testRoot;
		
		IntStream.range(1, n).parallel().forEach((i) -> 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		});  
        
        System.out.println(BinaryTree.PostOrder(expectedRoot));
        System.out.println(BinaryTree.PostOrder(testRoot));
		
        assertEquals(BinaryTree.PostOrder(expectedRoot), BinaryTree.PostOrder(testRoot));
    }
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 10, 10, 20, 20, 50, 50, 100, 100 })
	public void GetLengthTest(int n) 
	{	
		TLNode expectedRoot = new TLNode(0);
		TLNode testRoot = new TLNode(0);
        
		leftBranch = rightBranch = expectedRoot;
		
		for(int i = 1; i < n; i++) 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		}
		
		leftBranch = rightBranch = testRoot;
		
		IntStream.range(1, n).parallel().forEach((i) -> 
		{
			leftBranch.left = new TLNode(-i);
			rightBranch.right = new TLNode(i);
			
			leftBranch = leftBranch.left;
			rightBranch = rightBranch.right;
		});  
        
        System.out.println(BinaryTree.GetLength(expectedRoot));
        System.out.println(BinaryTree.GetLength(testRoot));
		
        assertEquals(BinaryTree.GetLength(expectedRoot), BinaryTree.GetLength(testRoot));
    }
}