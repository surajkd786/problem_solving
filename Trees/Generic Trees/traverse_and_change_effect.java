
import java.io.*;
import java.util.*;

public class traverse_and_change_effect {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int size;
    static int max;
    static int min;
    static int height;

    public static void multiSolver(Node node, int depth) {
        size++;
        min = Math.min(node.data, min);
        max = Math.max(node.data, max);
        height = Math.max(depth, height);
        for (Node child : node.children) {
            multiSolver(child, depth + 1);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        size = 0;
        height = 0;
        multiSolver(root, 0);
        System.out.println("size = " + size);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("height =" + height);
    }

}