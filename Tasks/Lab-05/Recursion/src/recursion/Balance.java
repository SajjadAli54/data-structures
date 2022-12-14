/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;
import java.util.Stack;

/**
 *
 * @author 023-19-0100
 */
public class Balance {
    
    public boolean balanced(String str){
        Stack<Character> s = new Stack<Character>();
        for(char x: str.toCharArray()){
            //System.out.print(x+". ");
            if((x == '[') || (x == '{') || (x == '(')){
                s.push(x);
            }
            else if(Character.isLetterOrDigit(x) || x == '+' ||x == '-' || x == '/' || x == '*'){}
            else{
                if(s.empty()){
                    return false;
                }
                char top = s.pop();
                //System.out.print(top+". ");
                if((top == '[' && x != ']') || (top == '{' && x != '}') || (top == '(' && x != ')')){
                    return false;
                }
            }
        }
        return s.empty();
    }
}
