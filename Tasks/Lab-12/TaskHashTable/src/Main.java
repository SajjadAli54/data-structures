import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashSetChain set = new MyHashSetChain();
        MyHashSetLinear linear = new MyHashSetLinear();

        String arr[] = get();
        for(var x : arr){
            set.add(x);
            linear.add(x);
        }
        //linear.print();
        for(var x:arr){
            System.out.println("Linear search : "+x + " "+ linear.search(x));
            System.out.println("Chain search : "+x + " "+ set.search(x));
        }
    }

    public static String[] get(){
        String arr[] = new String[30];
        File file = new File("Names.txt");
        try {
            Scanner sc = new Scanner(file);
            int i = 0;
            while (sc.hasNextLine()){
                arr[i++] = sc.nextLine();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}
