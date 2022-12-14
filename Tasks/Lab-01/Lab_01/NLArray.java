/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_01;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Sajjad Ali
 */
public class NLArray {

    /**
     * @param args the command line arguments
     */
    
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
       char arr[] = {',','.','/','?','!','@','#','$','%','^','&','*','(',')','-','=','+',';',':','\'','\"','\\','|','{','}','[',']'};
       
       for(char x:arr){
           text = text.replace(x+"", "");
       }
       
       return text.split(" ");
    } 
            
    public static void main(String[] args) {
        // TODO code application logic here
        
        String str = "NLArray.java";
        String arr[] = new NLArray().wordTokenize(str);
        for(String x:arr){
            System.out.print(x+" ");
        }
    }
    
}
