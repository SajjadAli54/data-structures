package linkeddictionary;
/**
 *
 * @author Sajjad Ali 
 * 023-19-0100
 * BSCS III Section B, Sukkur IBA University
 * Data Structure Theory 
 * Dictionary Assignment#01
 * October 2020
 * 
 * Sir Saif Hassan
 */
public class Dictionary {
    
    Node head = null;
    Node tail = null;
    
    public boolean find(int key){
        if(head == null){
            return false;
        }
        Node c = head;
        while(c != null){
            if(c.key == key){
                return true;
            }
            c = c.next;
        }
        return false;
    }
    
    public void add(int key,String name){
        if(find(key)){
            System.out.println(key+" Key already exist");
            return;
        }
        if(head == null){
            head = new Node(key,name);
            tail = head;
        }
        else{
            Node n = new Node(key,name);
            tail.next = n;
            tail = n;
        }
    }
    
    public String retrieve(int key){
        Node c = head;
        String name = "";
        while(c != null && c.key != key){
            c = c.next;
        }
        if(c != null){
            name = c.name;
        }
        else{
            name = null;
        }
        
        return name;
    }
    
    public String remove(int key){
        Node c = head;
        if(c.key == key){
            String name = c.name;
            head = c.next;
            return name;
        }
        while(c != null && c.next.key != key){
            c = c.next;
        }
        if(c.next.key == key){
            String name = c.next.name;
            c.next = c.next.next;
            return name;
        }
        else{
            return null;
        }
        
    }
    
    public void set(int key,String name){
        Node c = head;
        while(c != null && c.key != key){
            c = c.next;
        }
        if(c != null){
            c.name = name;
        }
    }
    
    public void print(){
        Node c = head;
        while(c != null){
            System.out.println("("+c.key+", \""+c.name+"\")");
            c = c.next;
        }
    }
    
}