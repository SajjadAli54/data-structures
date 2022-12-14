/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;
import java.util.Scanner;

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
       Balance b = new Balance();
       
       Scanner sc = new Scanner(System.in);
       System.out.print("Input : ");
       String str = sc.nextLine();
       
       System.out.println(b.balanced(str));
    }
    
    
}
