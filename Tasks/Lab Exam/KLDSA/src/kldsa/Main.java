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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operations o = new Operations();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            System.out.println("Please enter your choice: (1 for insert, 2 for undo, 3 for redo, 4 display stack) ");
            n = sc.nextInt();
            if(n == 1){
                sc.nextLine();
                System.out.print("Input word : ");
                String str = sc.nextLine();
                o.push(str);
            }
            else if(n == 2){
                o.undo();
            }
            else if(n == 3){
                o.redo();
            }
            else if(n == 4){
                o.print();
            }
        }
        while(n>0 && n<=4);
        
    }
}
