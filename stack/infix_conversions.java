import java.io.*;
import java.util.*;

public class infix_conversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        // code
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            } else if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != '(') {

                    processing(ops, postfix, prefix);
                }
                ops.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {

                    processing(ops, postfix, prefix);
                }
                ops.push(ch);
            }
        }

        while (ops.size() > 0) {

            processing(ops, postfix, prefix);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    public static void processing(Stack<Character> ops, Stack<String> postfix, Stack<String> prefix) {
        char op = ops.pop();
        // for postfix
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        String postv = postv1 + postv2 + op;
        postfix.push(postv);
        // for prefix
        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev = op + prev1 + prev2;
        prefix.push(prev);
    }

    public static int precedence(char optor) {
        if (optor == '+') {
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        } else {
            return 2;
        }
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