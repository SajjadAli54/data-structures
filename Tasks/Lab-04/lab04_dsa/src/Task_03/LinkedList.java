package Task_03;

import javax.swing.text.html.StyleSheet;

public class LinkedList {
    public static void print(Node n){
        while(n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public static void printRc(Node n){
        if(n == null){
            System.out.println();
            return;
        }
        System.out.print(n.data+" ");
        printRc(n.next);
    }

    public static void time(double a, double b){
        if(a < b){
            System.out.println("Time for a is less tha b");
        }
        else{
            System.out.println("Time for b is less tha a");
        }
    }

    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        double t1 = System.nanoTime();
        LinkedList.print(head);
        double t2 = System.nanoTime();

        double t3 = System.nanoTime();
        LinkedList.printRc(head);
        double t4 = System.nanoTime();

        LinkedList.time(t2-t1,t4-t3);
    }
}

class Node{
    int data = 0;
    Node next = null;

    public Node(int v){
        data = v;
    }
}
