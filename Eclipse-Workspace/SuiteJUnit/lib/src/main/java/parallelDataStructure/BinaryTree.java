package parallelDataStructure;

// https://www.mygreatlearning.com/blog/data-structures-using-java/
public class BinaryTree
{
    public static final char separator = ' ';
    public static final String empty = new String("");

    public static void preorder(TLNode r)
    {
        if(r == null)
            return;

        System.out.print(r.data+" ");

        preorder(r.left);
        preorder(r.right);

    }

    public static String PreOrder(TLNode r)
    {
        if(r == null)
            return empty;

        var text = new StringBuilder();
        
        text.append(r.data);
        text.append(separator);

        text.append(PreOrder(r.left));
        text.append(PreOrder(r.right));

        return text.toString();
    }

    public static void inorder(TLNode r)
    {
        if(r == null)
            return;

        inorder(r.left);
        System.out.print(r.data + " ");
        inorder(r.right);
    }

    public static String InOrder(TLNode r)
    {
        if(r == null)
            return empty;

        var text = new StringBuilder();

        text.append(InOrder(r.left));

        text.append(r.data);
        text.append(separator);
        
        text.append(InOrder(r.right));

        return text.toString();
    }

    public static void postorder(TLNode r)
    {
        if(r == null)
            return;

        postorder(r.left);
        postorder(r.right);
        System.out.print(r.data + " ");
    }

    public static String PostOrder(TLNode r)
    {
        if(r == null)
            return empty;

        var text = new StringBuilder();

        text.append(PostOrder(r.left));
        text.append(PostOrder(r.right));

        text.append(r.data);
        text.append(separator);

        return text.toString();
    }

    public static Integer GetLength(TLNode r)
    {
        if(r == null)
            return 0;

        var count = 1;

        count += GetLength(r.left);
        count += GetLength(r.right);

        return count;
    }
}