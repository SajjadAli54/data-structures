import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    Node root = null;

    public void insert(int data){
        root = insert(root,data);
    }
    private Node insert(Node root,int data){
        if(root == null)
            root = new Node(data);
        else if(data < root.data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    public void add(int data){
        Node node = new Node(data);
        if(root == null)
            root = node;
        else {
            Node c = root;
            while (c != null){
                if(data < c.data){
                    if(c.left == null) {
                        c.left = node;
                        break;
                    }
                    c = c.left;
                }
                else {
                    if(c.right == null){
                        c.right = node;
                        break;
                    }
                    c =c.right;
                }
            }
        }
    }

    public boolean search(int value){
        return search(root,value);
    }
    private boolean search(Node root,int value){
        if(root == null)
            return false;
        if(value < root.data)
            return search(root.left,value);
        else if(value > root.data)
            return search(root.right,value);
        else
            return true;
    }

    public Node find(int value){
        boolean flag = false;
        Node c = null;
        if(root != null){
            c = root;
            while (c != null){
                if(value < c.data)
                    c = c.left;
                else if(value > c.data)
                    c = c.right;
                else {
                    flag = true;
                    break;
                }
            }
        }
        return c;
    }
    private Node findmin(Node root){
        if(root != null){
            while (root.left != null)
                root = root.left;
        }
        return root;
    }

    public int min(){
        return min(root);
    }
    private int min(Node root){
        if(root == null)
            return -1;
        if(root.left == null)
            return root.data;
        return min(root.left);
    }

    public int minimum(){
        int min = -1;
        if(root != null){
            Node c = root;
            while (c.left != null)
                c = c.left;
            min = c.data;
        }
        return min;
    }

    public int max(){
        return max(root);
    }
    private int max(Node root){
        if(root == null)
            return -1;
        if(root.right == null)
            return root.data;
        return max(root.right);
    }

    public int maximum(){
        int max = -1;
        if(root != null){
            Node c = root;
            while (c.right != null)
                c = c.right;
            max  = c.data;
        }
        return max;
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    private boolean isLeaf(Node node){
        return node != null && (node.left == null && node.right == null);
    }

    public void pre_order(){
        System.out.println("Pre Order Traversal");
        pre_order(root);
        System.out.println();
    }
    private void pre_order(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            pre_order(root.left);
            pre_order(root.right);
        }
    }

    public void in_order(){
        System.out.println("In Order Traversal");
        in_order(root);
        System.out.println();
    }
    private void in_order(Node root){
        if(root != null){
            in_order(root.left);
            System.out.print(root.data+" ");
            in_order(root.right);
        }
    }

    public void post_order(){
        System.out.println("Post Order Traversal");
        post_order(root);
        System.out.println();
    }
    private void post_order(Node root){
        if(root != null){
            post_order(root.left);
            post_order(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void level_order(){
        int height = height();
        System.out.println("Level Order Traversal");
        for(int i = 0;i<=height;i++){
            printAtDistance(i);
            System.out.println();
        }
    }

    public boolean equals(BinaryTree tree){
        if(tree == null)
            return false;
        return equals(root, tree.root);
    }
    private boolean equals(Node first,Node sec){
        if(first == null && sec == null)
            return true;
        if(first != null && sec != null){
            if(first.data == sec.data)
                return equals(first.left, sec.left) && equals(first.right, sec.right);
            return false;
        }
        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root,int min,int max){
        if(root == null)
            return true;
        if(root.data<min || root.data > max)
            return false;
        return isBinarySearchTree(root.left,min,root.data) &&
                isBinarySearchTree(root.right,root.data,max);
    }

    public void printAtDistance(int distance){
        printAtDistance(root,distance);
    }
    private void printAtDistance(Node root,int distance){
        if(root == null)return;
        if(distance == 0)
            System.out.print(root.data+" ");
        else {
            printAtDistance(root.left,distance-1);
            printAtDistance(root.right,distance-1);
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node root){
        if(root == null)
            return  0;
        return 1 + size(root.left) + size(root.right);
    }

    public int countLeaves(){
        return countLeaves(root);
    }
    private int countLeaves(Node root){
        if(root == null)
            return 0;
        if(isLeaf(root))
            return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public boolean areSiblings(int left,int right){
        boolean flag = false;
        if(root != null){
            List<Integer> l = getAncestors(left);
            List<Integer> r = getAncestors(right);
            if(l.equals(r))
                flag = true;
        }
        return flag;
    }

    public boolean areCousins(int a, int b) {
        boolean flag = false;
        if (root != null) {
            List<Integer> l = getAncestors(a);
            List<Integer> r = getAncestors(b);
            if (l != null && r != null )
                l.remove(l.size()-1);
                r.remove(r.size()-1);
                if(l.equals(r))
                    flag = true;
        }
        return flag;
    }

    public List<Integer> getAncestors(int value){
        List<Integer> list = null;
        if(search(value)){
            Node c = root;
            list = new LinkedList<Integer>();
            while (c != null){
                if(value != c.data) list.add(c.data);
                else break;
                c = value < c.data ? c.left : c.right;
            }
        }
        return list;
    }

    public void remove(int data){
        root = remove(data,root);
    }
    private Node remove(int data,Node root){
        if(root != null){
            if(data < root.data)
                root.left = remove(data, root.left);
            else if(data > root.data)
                root.right = remove(data, root.right);
            else {
                if(isLeaf(root))
                    root = null;
                else if(root.left == null)
                    root = root.right;
                else if(root.right == null)
                    root = root.left;
                else {
                    Node temp = findmin(root.right);
                    root.data = temp.data;
                    root.right = remove(root.data,root.right);
                }
            }
        }
        return root;
    }

    public Node leftDescendent(Node n){
        if(n.left == null)
            return n;
        else
            return leftDescendent(n.left);
    }

    public List range(int x, int y){
        LinkedList<Node> list = new LinkedList<Node>();
        range(x,y,root,list);
        return list;
    }
    private void range(int x, int y,Node root,List list){
        if(root != null){
            if(root.data >= x && root.data <= y){
                list.add(root.data);
            }
            range(x,y,root.left,list);
            range(x,y, root.right,list);
        }
    }
}