public class insertAVL {
    Node root = null;

    private Node insert(int value,Node root){
        if(isEmpty(root))
            root = new Node(value);
        else if(value < root.data)
            root.left = insert(value,root.left);
        else
            root.right = insert(value,root.right);
        setHeights(root);
        if(!isAVL(root))
            root = balance(root);
        return root;
    }

    private Node balance(Node root){
        if(isLeftHeavy(root)){
            if(balanceFactor(root.left) < 0)
                root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        else if(isRightHeavy(root)){
            if(balanceFactor(root.right) > 0)
                root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        return root;
    }

    private Node leftRotate(Node root){
        Node newNode = root.right;
        root.right = newNode.left;
        newNode.left = root;

        setHeights(root);
        setHeights(newNode);
        return newNode;
    }

    private Node rightRotate(Node root){
        Node newNode = root.left;
        root.left = newNode.right;
        newNode.right = root;

        setHeights(root);
        setHeights(newNode);
        return newNode;
    }

    private int height(Node node){
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(Node node){
        return node == null ? 0 :
                height(node.left) - height(node.right);
    }

    private void setHeights(Node root){
            root.height =
                    Math.max(height(root.left),height(root.right)) + 1;
    }

    private boolean isLeftHeavy(Node tree){
        return balanceFactor(tree) > 1;
    }

    private boolean isRightHeavy(Node tree){
        return balanceFactor(tree) < -1;
    }

    private boolean isAVL(Node tree){
        return Math.abs(balanceFactor(tree)) <= 1;
    }

    private boolean isEmpty(Node subtree){
        return subtree == null;
    }
}

class Node {
    int data = 0;
    int height = 0;
    Node left = null;
    Node right = null;

    public Node(int data){
        this.data = data;
    }
}
