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
public class Task_01 {

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack stack = new Stack(3);
        
        stack.push(1);
        stack.push(2);
        
        stack.pop();
        stack.pop();
        
        stack.push(3);
        
        System.out.println("Top element is "+stack.peek());
        System.out.println("Stack size is " + stack.size()); 
        
        stack.pop(); 
        
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }
    }
    
    static class Stack{
    private int arr[];
    private int top;
    private int capacity;
    
    public Stack(int size){
        arr = new int[size];
        top = -1;
        capacity = size;
    }
    
    public void push(int x){
        if(top >= (capacity-1)){
            System.out.println("Stack is full");
        }
        else{
            arr[++top] = x;
            System.out.println("Inserting "+x);
        }
    }
    
    public int pop(){
        if(top<0){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            System.out.println("Removing "+arr[top]);
            return arr[top--]; 
        }
    }
    
    public int peek(){
        if(top<0){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            System.out.println("Peeking "+arr[top]);
            return arr[top];
        }
    }
    
    public int size(){
        return top+1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean full(){
        return top == (capacity - 1);
    }
    
 }

    
}

