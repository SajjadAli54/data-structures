/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;
import java.util.Vector;

/**
 *
 * @author 023-19-0100
 */
public class LinkedList {
    Node head = null;
    
    public void pushFront(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }
    // Task _01
    public Node makeReverse(Node head){
        Node next = null, prev = null;
        
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
        Vector<Integer> vec = new Vector<Integer>();
        while(c != null){
            vec.add(0, c.data);
            c = c.next;
        }
        System.out.println(vec.toString());
    }
    
    // Task _03
    public void makeCycle(Node n){
        Node c = head;
        while(c.next != null){
            c = c.next;
        }
        c.next = n;
    }
    public boolean hasCycle(){
        Node slow = head;
        Node fast = head;
       
        try{
            while(fast != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
        }
        catch(Exception e){}
        
        return false;
    }
    
    public void print(){
        Node c = head;
        while(c != null){
            System.out.print(c.data + " ");
            c = c.next;
        }
        System.out.println();
    }
    
}
