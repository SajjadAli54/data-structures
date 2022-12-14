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
public class Task_03 {
    
    public static void main(String args[]){
        
        Queue q = new Queue(5);
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek()); 
        System.out.println("Queue size is " + q.size()); 
        
        q.dequeue();
        q.dequeue();
        
        System.out.println(q.isEmpty() ? "Queue is empty" : "Queue is not empty");
        
        
    }
    
    static class Queue{
        int arr[];
        private int front = 0;
        private int rear = -1;
        private int capacity = 0;
        private int count = 0;
        
        public Queue(int size){
            capacity = size;
            arr = new int[size];
        }
        
        public int dequeue(){
            if(count == 0){
                System.out.println("Queue is empty");
                return 0;
            }
            else{
                System.out.println("Removing "+arr[front]);
                front = (front + 1) % capacity;
                count--;
                return arr[front];
            } 
        }
        
        public void enqueue(int x){
            if(count == capacity){
                System.out.println("Queue is full");
            }
            else{
                rear = (front + count) % capacity;
                arr[rear] = x;
                count++;
                System.out.println("Inserting "+x);
            }
        }
        
        public int peek(){
            if(count == 0){
                System.out.print("Queue is empty   ");
                return 0;
            }
            else{
                return arr[front];
            }
        }
        
        public int size(){
            return count;
        }
        
        public boolean isEmpty(){
            return count == 0;
        }
        
        public boolean isFull(){
            return count == capacity;
        }
    }
}
