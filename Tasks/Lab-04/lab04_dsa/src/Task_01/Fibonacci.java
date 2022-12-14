package Task_01;

import java.util.Scanner;

public class Fibonacci {
    public static void fibo(int n){
        int a = 0, b = 1, c = 0;
        while(c <= n){
            System.out.print(c+" ");
            a = b;
            b = c;
            c = a + b;
        }
        System.out.println();
    }

    public static void fiboRecursive(int a,int n){
        if(n<0){
            System.out.println();
            return;
        }
        System.out.print(n+" ");
        n -= ++a;
        fiboRecursive(a,n);
    }

    public static double time(){
        return System.nanoTime()/1000000.0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        int n = sc.nextInt();

        double t1 = Fibonacci.time();
        Fibonacci.fibo(n);
        double t2 = Fibonacci.time();

        double time_a = t2 - t1;

        t1 = Fibonacci.time();
        Fibonacci.fiboRecursive(0,n);
        t2 = Fibonacci.time();

        double time_b = t2 - t1;

        System.out.println("Time for a  "+time_a+" micro seconds");

        System.out.println("Time for b  "+time_b+" micro seconds");

        if(time_a < time_b){
            System.out.println("Time for a is less than Time for b");
        }
        else{
            System.out.println("Time for b is less than Time for a");
        }
    }
}
