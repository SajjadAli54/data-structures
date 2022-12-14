import java.util.Stack;

public class Balance {

    // Task _04
    public boolean isBalanced(String str){
        Stack<Character> s = new Stack<Character>();
        for(char x : str.toCharArray()){
            if(x == '[' || x == '{' || x == '('){
                s.push(x);
            }
            else if(Character.isLetterOrDigit(x) || x == '+' || x == '-' || x == '/' || x == '*' || x == '='){}
            else{
                if(s.empty()){
                    return false;
                }
                char top = s.pop();
                if((top == '[' && x != ']') ||
                        (top == '{' && x != '}') ||
                        (top == '(' && x != ')')){
                    return false;
                }
            }
        }
        return s.empty();
    }

    public static void main(String args[]){
        Balance b = new Balance();
        System.out.println(b.isBalanced("[a+{b+(c+4)}+232]]"));
    }
}
