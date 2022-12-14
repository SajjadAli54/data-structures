/**
 *
 * @author Sajjad Ali   023-19-0100
 * Data Structure Lab_02
 * Computer Science Department
 * Semester 03  
 * Sep 2020
 * 
 * Sir Saif Hassan
 */

public class Task_01 {

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        
        list.insertAtEnd("Sajjad");
        list.insertAtBeginning("Neha Ali");
        list.insertAfterName("Sajjad", new Node("Sajan Ali"));
        list.insertBeforeName("Sajan Ali", new Node("Aroosa"));
        list.insertAtEnd(new Node("Shehenshah"));
        list.insertAtBeginning(new Node("Barhe Sahab"));
        
        list.printAll();
        
        list.makeCircular();
    }
    
}

class DoubleLinkedList{

    Node head = null;

    public void insertAtBeginning(String name){
	insertAtBeginning(new Node(name));
    }

    public void insertAtBeginning(Node n){
	if(head == null){
	    head = n;
	    return;
	}
	head.pre = n;
	n.next = head;
	head = n;
    }

    public void insertAtEnd(String name){
	insertAtEnd(new Node(name));
    }

    public void insertAtEnd(Node n){
	if(head == null){
	   head = n;
	   return;
	}
	Node c = head;
	while(c.next != null){
	   c = c.next;
	}
	c.next = n;
	n.pre = c;
    }

    public void insertAfterName(String name,Node n){
	if(head == null)	return;
	
	Node c = head;
	try{
            while(!c.name.equals(name)){
                c = c.next;
            }
        }
        catch(Exception e){
            System.out.println(name + " name not found");
            return;
        }
        
	if(c.next == null){
	   insertAtEnd(n);
	   return;
	}
        
	n.pre = c;
	n.next = c.next;
	c.next.pre = n;
	c.next = n;
    }

    public void insertBeforeName(String name,Node n){
	if(head == null)	return;

	if(head.name.equals(name)){
	   insertAtBeginning(n);
	   return;
	}
        
	Node c = head;
	try{
            while(!c.name.equals(name)){
                c = c.next;
            }
        }
        catch(Exception e){
            System.out.println(name + " name not found");
            return;
        }

	n.next = c;
	n.pre = c.pre;
	c.pre.next = n;
	c.pre = n;
    }

    public void makeCircular(){
	if(head == null || head.pre != null)	return;

	Node c = head;
	while(c.next != null)	c = c.next;

	c.next = head;
	head.pre = c;
    }

    public void printAll(){
	if(head == null)	return;

	Node c = head;
	while(c.next != null && c.next != head){
		System.out.println(c.name);
		c = c.next;
	}
        System.out.println(c.name);
    }
}

class Node{
	String name = null;
	Node pre = null, next = null;
	public Node(String name){
		this.name = name;
	}
    } 