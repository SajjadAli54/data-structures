package Task_04;

import javax.swing.text.html.StyleSheet;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {

    public boolean search(int arr[],int n){
        boolean flag = false;
        for(int x:arr){
            if(x == n){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean searchRec(int arr[],int n){
        if(arr.length == 0){
            return false;
        }
        if(arr[0] == n){
            return true;
        }
        int num[] = Arrays.copyOfRange(arr,1,arr.length);
        return searchRec(num,n);
    }

    public void time(double a, double b){
        System.out.println("Time a : "+a+"\nTime b : "+b);
        if(a < b){
            System.out.println("Time for a is less tha b");
        }
        else{
            System.out.println("Time for b is less tha a");
        }
    }

    public static void main(String args[]){
        Array a = new Array();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = r.nextInt(50) % 5;
        }

        System.out.print("Input : ");
        int n = sc.nextInt();

        long t1 = System.nanoTime();
        System.out.println(a.search(arr,n));
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        System.out.println(a.searchRec(arr,n));
        long t4 = System.nanoTime();

        a.time(t2-t1,t4-t3);
    }
}
