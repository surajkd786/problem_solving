
// import java.io.*;
import java.util.*;

public class balanced_brackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if (st.size() != 0) {
                    if (st.peek() == '(' && ch == ')') {

                        st.pop();
                    } else if (st.peek() == '{' && ch == '}') {
                        st.pop();
                    } else if (st.peek() == '[' && ch == ']') {
                        st.pop();
                    }
                } else {
                    System.out.println(false);
                    return;
                }

            } else {
                if (ch == '(') {
                    st.push(ch);
                } else if (ch == '{') {
                    st.push(ch);
                } else if (ch == '[') {
                    st.push(ch);
                }
            }
        }
        if (st.size() == 0) {
            System.out.println("true");
        } else
            System.out.println("false");

    }
}