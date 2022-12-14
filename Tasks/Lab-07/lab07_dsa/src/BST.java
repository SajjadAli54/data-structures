public class BST {
    Node root = null;

    public void insert(int data){root = insert(data,root);}
    private Node insert(int data,Node root){
        Node n = new Node(data);
        if(root == null)     root = n;
        else if(data < root.data)  root.left = insert(data,root.left);
        else    root.right = insert(data,root.right);
        return root;
    }

    public boolean search(int data){
        boolean flag = false;
        Node cur = root;
        while (cur != null){
            if(data < cur.data) cur = cur.left;
            else if(data > cur.data) cur = cur.right;
            else{flag = true; break;}
        }
        return flag;
    }

    public void preorder(){ System.out.println("Preorder");preorder(root);   System.out.println();}
    private void preorder(Node root){ if(root != null){System.out.print(root.data+" "); preorder(root.left); preorder(root.right);} }

    public void inorder(){System.out.println("Inorder");inorder(root);   System.out.println();}
    private void inorder(Node root){if(root != null){inorder(root.left);     System.out.print(root.data+" "); inorder(root.right);}}

    public void postorder(){System.out.println("Postorder"); postorder(root);   System.out.println(); }
    private void postorder(Node root){if(root != null){postorder(root.left); postorder(root.right);   System.out.print(root.data+" ");}}

    public int height(){return height(root);}
    private int height(Node root){
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left),height(root.right)) + 1;
    }
}
