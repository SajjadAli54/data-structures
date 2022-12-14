package Task_02;

import java.util.Scanner;

public class Factorial {
    public static int fact(int n){
        int val = 1;
        for(int i=1;i<=n;i++){
            val *= i;
        }
        System.out.println(val);
        return val;
    }

    public static int factRec(int n){
        if(n<1){
            System.out.println();
            return 1;
        }
        return n *  factRec(--n);
    }

    public static double time(){
        return System.nanoTime()/1000000.0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        int n = sc.nextInt();

        double t1 = Factorial.time();
        Factorial.fact(n);
        double t2 = Factorial.time();

        double time_a = t2 - t1;

        t1 = Factorial.time();
        System.out.println(Factorial.factRec(n));
        t2 = Factorial.time();

        double time_b = t2 - t1;

        System.out.println("Time for a "+time_a);
        System.out.println("Time for b "+time_b);
        if(time_a < time_b){
            System.out.println("Time foe a is less than b");
        }
        else{
            System.out.println("Time for b is less than a");
        }
    }
}
