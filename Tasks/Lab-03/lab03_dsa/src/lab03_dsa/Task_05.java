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
public class Task_05 {
    
    public static void main(String args[]){
        int[] keys = { 1, 2, 3, 4, 5 }; 
        Queue q = new Queue();
        
        for(int x:keys){
            q.enqueue(x);
        }
        
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue()); 
    }
    
    static class Queue{
        private Stack s1, s2;
        
        Queue(){
            s1 = new Stack();
            s2 = new Stack();
        }
        
        public void enqueue(int x){
            s1.push(x);
        }
        
        public int dequeue(){
            for(int i=s1.size()-1;i>=0;i--){
                s2.push(s1.pop());
            }
            
            int data = s2.pop();
            
            s1 = new Stack();
            for(int i=s2.size()-1;i>=0;i--){
                s1.push(s2.pop());
            }
            
            s2 = new Stack();
            return data;
        }
    }
    
}
