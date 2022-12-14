import java.util.Vector;

public class LinkedList {
    Node head = null;

    //Task _ 01
    public Node makeReverse(Node head){
        Node prev = null, next = null;

        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        this.head = prev;
        return this.head;
    }

    // Task _02
    public void printReverse(){
        Node c = head;
        Vector<Integer> v = new Vector<Integer>();

        while(c != null){
            v.add(0,c.data);
            c = c.next;
        }
        System.out.println(v.toString());
    }

    // Task _ 03
    public boolean hasCycle(){
        Node slow = head, fast = head;
        Node c = head;

        try {
            while (fast != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }catch(Exception e){}
        return false;
    }

    public void makeCycle(Node n){
        Node c = head;
        while (c.next != null){
            c = c.next;
        }
        c.next = n;
    }

    public void add(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

}
