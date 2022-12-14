/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_01;

/**
 *
 * @author Sajjad Ali
 */
public interface List {
    
    boolean isEmpty();
    int size();
    
    void add(Object o);
    void add(int i,Object o);
    
    void remove(int i);
    void remove(Object o);
    
    List duplicate();
    List duplicateReversed();
}
