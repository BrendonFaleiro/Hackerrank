import java.util.*;

public class BracketStack {
     public static boolean isBalanced(String expression) {
         Stack<Character> bs = new Stack<Character>();
         char c;
         for(int i=0;i<expression.length();i++){
             c = expression.charAt(i); 
             //System.out.println(c);
             switch(c){
                 case '[':
                 case '{':
                 case '(':
                    bs.push(c);
                    break;
                 case ']':
                    //d = bs.pop();
                    //System.out.println("Popped:"+d);
                    if(bs.isEmpty() || !bs.pop().toString().equals("["))
                        return false;
                    break;
                 case '}':
                    //d = bs.pop();
                    //System.out.println("Popped:"+d);
                 if(bs.isEmpty() || !bs.pop().toString().equals("{"))
                        return false;
                    break;
                 case ')':
                    //d = bs.pop();
                    //System.out.println("Popped:"+d);
                    if(bs.isEmpty() || !bs.pop().toString().equals("("))
                        return false;
                    break;
                 default:
                    return false;
                    
             }
         }
         if(!bs.empty())
         {
             //System.out.println("still looking and not empty");
            return false;   
         }
         else
             return true;
     }
  
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
             boolean answer = isBalanced(expression);
             if(answer)
              System.out.println("YES");
             else System.out.println("NO");
        }
        in.close();
    }
}
