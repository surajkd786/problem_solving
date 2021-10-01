import java.io.*;
import java.util.*;

public class postfix_evaluation_and_conversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        // code
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch=='+'||ch=='-'||ch=='*'||ch=='/') {
                //calculating values
                int v2=values.pop();
                int v1=values.pop();
                values.push(operation(v1, v2, ch));
                //infix evaluation
                String inv2=infix.pop();
                String inv1=infix.pop();
                infix.push('('+inv1+ch+inv2+')');
                //prefix evaluation
                String preV2=prefix.pop();
                String preV1=prefix.pop();
                prefix.push(ch+preV1+preV2);
            }else{
                values.push(ch-'0');
                infix.push(ch+"");
                prefix.push(ch+"");
            }
           
        }
        System.out.println(values.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
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