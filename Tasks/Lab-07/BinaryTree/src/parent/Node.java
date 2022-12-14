package parent;

public class Node {
    int data = 0;
    Node left = null;
    Node right = null;
    Node parent = null;

    public Node(int data,Node parent){
        this.data = data;
        this.parent = parent;
    }
}
