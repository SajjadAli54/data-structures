/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03_dsa;

/**
 *
 * @author 023-19-0100
 */
public class Task_02 {
    
    public static void main(String args[]){
        
        Stack stack = new Stack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element is "+stack.peek());
        
        stack.pop();
        stack.pop();
        stack.pop();
        
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }
        
    }

    
}

class Node{
        int data = 0;
        Node next = null;
        
        Node(int data){
            this.data = data;
        }
}
class Stack{
        private Node top = null;
        
        public void push(int x){
            Node n = new Node(x);
            if(top == null){
                top = n;
                //System.out.println("Inserting "+x);
            }
            else{
                n.next = top;
                top = n;
                //System.out.println("Inserting "+x);
            }
        }
        
        public boolean isEmpty(){
            return top == null;
        }
        
        public int peek(){
            if(top == null){
                System.out.println("Stack is empty");
                return 0;
            }
            else{
                int data = top.data;
                System.out.println("Peeking "+data);
                return data;
            }
        }
        
        public int pop(){
            if(top == null){
                System.out.println("Stack is empty");
                return 0;
            }
            else{
                int data = top.data;
                top = top.next;
                //System.out.println("Poping "+data);
                return data;
            }
        }
        
        public int size(){
            int size = 0;
            Node c = top;
            while( c != null){
                c = c.next;
                size++;
            }
            return size;
        }
}

