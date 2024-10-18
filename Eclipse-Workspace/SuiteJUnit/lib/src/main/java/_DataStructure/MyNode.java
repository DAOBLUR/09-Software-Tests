package _DataStructure;

//https://www.prepbytes.com/blog/linked-list/find-the-smallest-and-largest-elements-in-a-singly-linked-list/

public class MyNode
{
    int data;
    MyNode next;
    
    public static MyNode head = null;

    static  public int largestElement(MyNode head)
    {
        
        int max = Integer.MIN_VALUE;

        while (head != null)
        {

            if (max < head.data)
                max = head.data;
            head = head.next;
        }
        return max;
    }

    static public int smallestElement(MyNode head)
    {

        int min = Integer.MAX_VALUE;

        while (head != null)
        {

            if (min > head.data)
                min = head.data;

            head = head.next;
        }
        return min;
    }

    static public void push(int data)
    {

    	MyNode newNode = new MyNode();

        newNode.data = data;

        newNode.next = (head);

        (head) = newNode;
    }

    static public void printList(MyNode head)
    {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

}