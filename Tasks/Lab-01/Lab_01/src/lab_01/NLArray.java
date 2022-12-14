/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sajjad Ali
 */
public class NLArray {

   
    
    String[] wordTokenize(String fileName){
       String text = "";
       try(InputStream is = new FileInputStream(fileName)){
           int b = 0;
           while((b = is.read()) != -1){
               text += (char)b;
           }
       }catch(Exception e){
           System.out.println(e);
       }
       char arr[] = {',','.','/','?','!','@','#','$','%','^','&','*','(',')','-','_','=','+',';',':','\'','\"','\\','|','{','}','[',']'};
       
       for(char x:arr){
           text = text.replace(x+"", "");
       }
       
       return text.split(" ");
    }
    
    String[] extractEmail(String fileName){
        String text = "";
        String arr[] = null;
        try(BufferedReader is = new BufferedReader(new FileReader(fileName))){
           String pattern = "[a-zA-Z0-9_.]" + "*@[a-zA-Z0-9-_.]" + "+([.][a-zA-Z]+)+";
           Pattern p = Pattern.compile(pattern);
           
           String line = is.readLine();
           while(line != null){
               Matcher m = p.matcher(line);
               while(m.find()){
                   text += m.group()+" ";
               }
               line = is.readLine();
           }
           text = text.trim();
           arr = text.split(" ");
        }catch(Exception e){
           System.out.println(e);
        }
        
        return arr;
    }
          
    public void extractBoundaries(int arr[][]){
        int r = arr.length, c = arr[0].length;
                 
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i == 0 || j == 0 || i == r-1 || j == c-1){
                    System.out.print(arr[i][j]+" ");
                }
                else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        
    }
    
    public void cropCentrePart(int arr[][]){
        int r = arr.length, c = arr[0].length;
                 
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i == 0 || j == 0 || i == r-1 || j == c-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
        
    }
    
    boolean NConRep (int arr[][]){
        boolean flag = false;
        int r = arr.length;
        int c = arr[0].length;
        
        for(int i=0;i<r;i++){
            int k = 0;
            for(int j=0;j<c;j++){
                if(arr[i][0] == arr[i][j]){
                    k++;
                }
            }
            if(k == c){
               flag = true;
               break;
            }
            else{
                k = 0;
            }
        }
        
        return flag;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        NLArray obj = new NLArray();
        
        String str = "NLArray.java";
        String arr[] = obj.wordTokenize(str);
        for(String x:arr){
            System.out.print(x+" ");
        }
        
        System.out.println("\n");
        
        str = "Email.txt";
        String[] ar = obj.extractEmail(str);
        
        for(String x:ar){
            System.out.println(x);
        }
        
        System.out.println("\n");
        
        Random rd = new Random();
        int n = rd.nextInt(5)+3;
        int m = rd.nextInt(5)+4;
        int[][] array = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = rd.nextInt(10);
            }
        }
        obj.extractBoundaries(array);
        
        System.out.println("\n");
        
        obj.cropCentrePart(array);
        
        System.out.println("\n");
        System.out.println(obj.NConRep(array));
    }
    
}
