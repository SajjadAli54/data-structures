
import java.util.Vector;

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

public class Task_03 {
      
    public boolean hasCycle(Node head){
        boolean flag = false;
        Vector<Node> list = new Vector<Node>();
        while(true){
            try{
                if(list.contains(head)){
                    return true;
                }
                list.add(head);
                head = head.next;
            }
            catch(NullPointerException e){
                flag = false;
                break;
            }
        }    
        return flag;
    }
    
    private static class Node{
	
	String name = null;
	Node next = null;

	public Node(String name){
		this.name = name;
        	}
    }
}
