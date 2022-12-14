package linkeddictionary;

/**
 * @author Sajjad Ali 
 * 023-19-0100
 * BSCS III Section B, Sukkur IBA University
 * Data Structure Theory 
 * Dictionary Assignment#01
 * October 2020
 * 
 * Sir Saif Hassan
 */
public class Node {
    int key = 0;
    String name = null;
    Node next = null;
    
    public Node(int key,String name){
        this.key = key;
        this.name = name;
    }
    
}
