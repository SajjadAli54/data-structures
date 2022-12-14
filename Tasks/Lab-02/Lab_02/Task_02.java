
/**
 *
 * @author Sajjad Ali      023-19-0100
 * Data Structure Lab_02
 * Computer Science Department
 * Semester 03 
 * Sep 2020
 * 
 * Sir Saif Hassan 
 */

public class Task_02 {
    
}

class DLL{
    Node head = null, tail = null;
    
    public void insertAtBeginning(String name){
        this.insertAtBeginning(new Node(name));
    }
    
    public void insertAtBeginning(Node n){
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            n.next = head;
            head.pre = n;
            head = n;
        }
    }
    
    public String removeBeginnig(){
        if(head == null){
            return null;
        }
        
        String name = head.name;
        head = head.next;
        head.pre = null;
        return name;
    } 
   
    public void insertAtEnd(String name){
        this.insertAtBeginning(new Node(name));
    }
    
    public void insertAtEnd(Node n){
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
    }
    
    public String removeEnd(){
        if(head == null){
            return null;
        }
        
        String name = tail.name;
        tail = tail.pre;
        tail.next = null;
        return name;
    }
    
    private static class Node{
	
	String name = null;
	Node pre = null, next = null;

	public Node(String name){
		this.name = name;
	}

    }
}

class SLL{
    
    Node head = null, tail = null;
    
    public void insertAtBeginning(String name){
        this.insertAtBeginning(new Node(name));
    }
    
    public void insertAtBeginning(Node n){
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            n.next = head;
            head = n;
        }
    }
    
    public String removeAtBeginning(){
        if(head == null){
            return null;
        }
        
        String name = head.name;
        head = head.next;
        return name;
    }
    
    public void inserAtEnd(String name){
        this.insertAtEnd(new Node(name));
    }
    
    public void insertAtEnd(Node n){
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            tail.next = n;
            tail = n;
        }
    }
    
    public String removeAtEnd(){
        if(head == null){
            return null;
        }
        String name = tail.name;
        Node c = head;
        while(c.next != tail){
            c = c.next;
        }
        tail = c;
        tail.next = null;
        return name;
    }
    
    private static class Node{
        String name = null;
        Node next = null;
        
        Node(String name){
            this.name = name;
        }
    }   
}