
/*1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.*/
import java.io.*;
import java.util.*;

public class infix_evaluation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        // code
        Stack<Integer> oprands = new Stack<>();
        Stack<Character> optor = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                optor.push(ch);
            } else if (Character.isDigit(ch)) {
                oprands.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (optor.size() >0 && optor.peek() != '(' && precedence(ch) <= precedence(optor.peek())) {
                    int v2 = oprands.pop();
                    int v1 = oprands.pop();
                    char op = optor.pop();
                    int opval=operation(v1, v2, op);
                    oprands.push(opval);
                }
                optor.push(ch);
            } else if (ch == ')') {
                while (optor.peek() == '(' && optor.size() > 0) {
                    int v2 = oprands.pop();
                    int v1 = oprands.pop();
                    char op = optor.pop();
                    int opval=operation(v1, v2, op);
                    oprands.push(opval);
                }
                if (optor.size() > 0) {
                    optor.pop();
                }
            }
        }

        while (optor.size() > 0) {
            int v2 = oprands.pop();
            int v1 = oprands.pop();
            char op = optor.pop();
            int opval=operation(v1, v2, op);
            oprands.push(opval);
        }

        int val = oprands.pop();
        System.out.println(val);
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