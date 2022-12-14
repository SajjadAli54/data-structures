package Task_00;

import java.util.Scanner;

public class SimpleRecursion {

    public static void printDescnding(int n){
        if(n == 1){
            System.out.println();
            return;
        }
        System.out.print(n+" ");
        printDescnding(--n);
    }

    public static void printAscending(int a,int n){
        if(a == n-1){
            System.out.println();
            return;
        }
        System.out.print(a+ " ");
        printAscending(++a,n);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int data = sc.nextInt();
        SimpleRecursion.printDescnding(data);
        SimpleRecursion.printAscending(0,data);
    }
}
