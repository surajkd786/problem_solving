import java.io.*;
import java.util.*;

public class queue {
public static void main(String[] args) throws Exception {
// Scanner scn = new Scanner(System.in);
    Queue<Integer>que=new ArrayDeque<>();
    que.add(10);
    System.out.println(que);
    que.add(20);
    System.out.println(que);
    que.add(30);
    System.out.println(que);

    System.out.println(que.peek());
    System.out.println(que);
    
    System.out.println(que.remove());
    System.out.println(que);
    }
}   