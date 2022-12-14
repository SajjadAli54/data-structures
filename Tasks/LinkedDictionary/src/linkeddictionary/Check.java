/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkeddictionary;

/**
 * @author Sajjad Ali 
 * 023-19-0100
 * BSCS III Section B, Sukkur IBA University
 * Data Structure Theory 
 * Dictionary Assignment#01
 * October 2020
 * 
 * Sir Saif Hassan
 */
public class Check {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dictionary d = new Dictionary();
        d.add(0, "Sajjad Ali");
        d.add(1, "Neha Ali");
        d.add(2, "Arslan");
        d.add(3, "Shaista");
        d.add(4, "Kamran");
        d.add(5, "Ahrar Ali");
        d.add(6, "Humayoun");
        d.add(7, "Shaheena");
        d.add(8, "Kulsoom");
        d.add(9, "Mohammad Ali");
        
        String name = d.remove(3);
        System.out.println("At key 3, value \""+name+"\" is successfully removed");
        
        d.set(2, "Yash");
        System.out.println("At key 1 we have : "+d.retrieve(1));
        d.print();
        
        System.out.println("Key 11 exist in dictionary :  "+d.find(11));
    }
    
}
