/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kldsa;
import java.util.*;

/**
 *
 * @author 023-19-0100
 */
public class Operations {
    Node head = null;
    Vector<String> str = new Vector<String>();
    
    public void push(String word){
        Node n = new Node(word);
        n.next = head;
        head = n;
    }
    
    public void undo(){
        if(head != null){
            str.add(head.word);
            head = head.next;
        }
        else{
            System.out.println("No data");
        }
    }
    
    public void redo(){
        if(str.size() != 0){
            push(str.get(str.size()-1));
            str.remove(str.get(str.size()-1));
        }
        else
            System.out.println("No undone");
    }
    
    public void print(){
        Node c = head;
        while(c!= null){
            System.out.print(c.word+" ");
            c = c.next;
        }
        System.out.println();
    }
}
