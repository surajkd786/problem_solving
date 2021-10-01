import java.io.*;
import java.util.*;

public class prefix_evaluation_and_conversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        // code
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i =exp.length()-1 ; i >=0 ; i--) {
            char ch = exp.charAt(i);
            if (ch=='+'||ch=='-'||ch=='*'||ch=='/') {
                //calculating values
                int v1=values.pop();
                int v2=values.pop();
                values.push(operation(v1, v2, ch));
                //infix evaluation
                String inv1=infix.pop();
                String inv2=infix.pop();
                infix.push('('+inv1+ch+inv2+')');
                //postfix evaluation
                String postV1=postfix.pop();
                String postV2=postfix.pop();
                postfix.push(postV1+postV2+ch);
            }else{
                values.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
           
        }
        System.out.println(values.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }

     public static int operation(int v1, int v2, char optor) {
        if (optor == '+') {
            return v1 + v2;
        } else if (optor == '-') {
            return v1 - v2;
        } else if (optor == '*') {
            return v2 * v1;
        } else {
            return v1 / v2;
        }
    }
}