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
public class Task_04 {
    
    public static void main(String args[]){
        Queue q = new Queue(); 
        
        q.enqueue(1); 
        q.enqueue(2); 
        q.enqueue(3); 
        q.enqueue(4); 
        
        System.out.printf("Front element is %d\n", q.peek());
        
        q.dequeue(); 
        q.dequeue();
        q.dequeue(); 
        q.dequeue();
        
        System.out.println(q.isEmpty() ? "Queue is empty" : "Queue is not empty");
    }
    
    static class Node{
        int data;
        Node next = null;
        
        Node(int data){
            this.data = data;
        }
    }
    
    static class Queue{
        private Node rear = null, front = null;
        
        public int dequeue(){
            int data = 0;
            if(front == null){
               System.out.println("Queue is empty");
            }
            else{
                data = front.data;
                front = front.next;
                System.out.println("Removing "+data);
            }
            
            return data;
        }
        
        public void enqueue(int x){
            Node n = new Node(x);
            if(front == null){
                front = n;
                rear = front;
            }
            else{
                rear.next = n;
                rear = n;
            }
            System.out.println("Inserting "+x);
        }
        
        public int peek(){
            int data = 0;
            if(front == null){
               System.out.println("Queue is empty");
            }
            else{
                data = front.data;
                //System.out.println("Peeking "+data);
            }
            
            return data;
        }
        
        public boolean isEmpty(){
            return front == null;
        }
    }
}
