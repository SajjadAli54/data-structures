/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_01;

/**
 *
 * @author Sajjad Ali
 */
public class LinkedList implements List {
    
    Node head;
    int size = 0;
    
    public LinkedList(){
        head = new Node(null);
    }
    
    public boolean isEmpty(){
        return head.next == null;
    }
    
    public int size(){
        int i = 0;
        Node c = head;
        while(c.next != null){
            c = c.next;
            i++;
        }
        return (size = i);
    }
    
    public void add(Object item){
        Node n = (Node)item;
        Node c = head;
        while(c.next != null){
            c = c.next;
        }
        c.next = n;
        size++;
    }
    
    public void add(int i,Object item){
        Node n = (Node)item;
        Node c = head;
        
        if(i<0 | i>size){
            System.out.println("IndexOutOfBoundsException");
            return;
        }
        if(i == size){
            add(item);
           return;
        }
        switch(i){
            case 0:
                n.next = c;
                c = n;
                size++;
                break;
            case 1:
                n.next = c.next;
                c.next = n;
                size++;
                break;
            default:
                int j = 0;
                while(j++ < (i-1)){
                    c = c.next;
                }
                n.next = c.next;
                c.next = n;
                size++;
                break;
        }
        
    }
    
    public void remove(int i){
        if(i<0 || i>size){
            System.out.println("IndexOutOfBoundsException");
            return;
        }
        Node c = head;
        switch(i){
            case 0:
                head = head.next;
                size--;
                break;
            case 1:
                head.next.next = head.next.next.next;
                size--;
                break;
            default:
                int j=0;
                while(j++ < (i-1)){
                    c = c.next;
                }
                c.next.next = c.next.next.next;
                size--;
                break;
        }
    }
    
    public void remove(Object item){
        Node n = (Node)item;
        if(equals(n,head.next)){
            remove(0);
            return;
        }
        if(equals(n,head.next.next)){
            remove(1);
            return;
        }
        int i = 1;
        Node c = head;
        while(!equals(c.next.next,n)){
            i++;
            c = c.next;
        }
        remove(i);
    }
    
    public List duplicate(){
        List list = this;
        return list;
    }
    
    public List duplicateReversed(){
        LinkedList list = new LinkedList();
        LinkedList dup = (LinkedList) this.duplicate();
        
        Node prev = null;
        Node c = dup.head.next;
        Node next = null;
        while(c != null){
            next = c.next;
            c.next = prev;
            prev = c;
            c = next;
        }
        list.add(prev);
        return list;
    }
    
    public String toString(){
        String str = "";
        str += "[the size of the list "+size()+"\n";
        Node c = head.next;
        while(c != null){
            if(c.next != null)
                str += c.data + ", ";
            else 
                str += c.data +"]";
            c = c.next;
        }
        return str;
    }
    
    public boolean equals(Node a,Node b){
        return a.data == b.data;
    }
    
    public static class Node{
        int data = 0;
        Node next;
        
        public Node(Node n){
            next = n;
        }
    }
    
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        
        for(int i=1;i<30;i++){
            Node a = new Node(null);
            a.data = i + i;
            list.add(a);
        }
        
        System.out.println(list);
        
        LinkedList dup =(LinkedList) list.duplicate();
        
        System.out.println(dup);
        
        LinkedList dupRev =(LinkedList) list.duplicateReversed();
        System.out.println(dupRev);
        
        Node a = new Node(null);
        a.data = 30;
        dupRev.remove(a);
        
        System.out.println(dupRev);
    }
}
