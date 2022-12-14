package parent;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    Node root;

    public void insert(int data){
        if(root == null){
            root = new Node(data,null);
        }
        else {
            Node c = root;
            while (c != null){
                if(data < c.data){
                    if(c.left == null){
                        c.left = new Node(data,c);
                        break;
                    }
                    c = c.left;
                }
                else if(data > c.data){
                    if(c.right == null){
                        c.right = new Node(data,c);
                        break;
                    }
                    c = c.right;
                }
                else {
                    System.out.println("Duplicate Data is not allowed");
                    break;
                }
            }
        }
    }

    public boolean search(int val){
        boolean falg  =false;
        if(root != null){
            Node c = root;
            while (c != null){
                if(val < c.data)
                    c = c.left;
                else if(val > c.data)
                    c = c.right;
                else {
                    falg = true;
                    break;
                }
            }
        }
        return falg;
    }

    private Node find(int val){
        Node found = null;
        if(root != null){
            Node c = root;
            while (c != null){
                if(val < c.data)
                    c = c.left;
                else if(val > c.data)
                    c = c.right;
                else {
                    found = c;
                    break;
                }
            }
        }
        return found;
    }

    public int leftDescendent(int data){
        Node leftD = find(data);
        return leftDescendent(leftD).data;
    }
    private Node leftDescendent(Node root){
        if(root.left == null)
            return root;
        return leftDescendent(root.left);
    }

    public int rightAncestor(int data){
        Node rightA = find(data);
        rightA = rightAncestor(rightA);
        if(rightA != null)
            return rightA.data;
        else
            return -1;
    }
    private Node rightAncestor(Node root) {
        if(root == null || root.parent == null)
            return null;
        if (root.data < root.parent.data)
            return root.parent;
        return rightAncestor(root.parent);
    }

    public int next(int data){
        Node found = find(data);
        found = next(found);
        return found != null ? found.data : -1;
    }
    private Node next(Node root){
        if(root.right != null)
            return leftDescendent(root.right);
        return rightAncestor(root);
    }

    public List range(int x, int y){
        Node node = find(x);
        List<Integer> list = new LinkedList<Integer>();
        while (node.data <= y){
            list.add(node.data);
            node = next(node);
        }
        return list;
    }

}
