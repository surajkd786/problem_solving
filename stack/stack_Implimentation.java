// import java.io.*;
// general operation in stack
// 1 push
// 2 pop
// 3 peek
import java.util.*;

public class stack_Implimentation {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
    Stack<Integer>st=new Stack<>();
    st.push(10);
    System.out.println(st+"->"+st.peek()+" "+st.size());
    st.push(20);
    System.out.println(st+"->"+st.peek()+" "+st.size());
    st.push(30);
    System.out.println(st+"->"+st.peek()+" "+st.size());
    st.pop();
    System.out.println(st+"->"+st.peek()+" "+st.size());
    st.pop();
    System.out.println(st+"->"+st.peek()+" "+st.size());
    st.pop();
    System.out.println(st+"->"+" "+st.size());

    }
}