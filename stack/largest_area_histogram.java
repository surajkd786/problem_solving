import java.io.*;
import java.util.*;

public class largest_area_histogram {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      // code
      Stack<Integer> st = new Stack<>();
      //array right least element
      int[] rb = new int[arr.length];
      st.push(arr.length - 1);
      rb[arr.length - 1] = arr.length;
      for (int i = rb.length - 2; i >= 0; i--) {
         while (st.size() != 0 && arr[i] <= arr[st.peek()]) {
            st.pop();
         }
         if (st.size() == 0) {
            rb[i] = arr.length;
         } else {
            rb[i] = st.peek();
         }
         st.push(i);
      }

      // left least element
      int[] lb = new int[arr.length];
      st = new Stack<>();
      st.push(0);
      lb[0] = -1;
      for (int i = 1; i < lb.length; i++) {
         while (st.size() != 0 && arr[i] <= arr[st.peek()]) {
            st.pop();
         }
         if (st.size() == 0) {
            lb[i] = -1;
         } else {
            lb[i] = st.peek();
         }
         st.push(i);
      }

      // area
      int max = 0;
      // int [] width=new int[arr.length];
      int width = 0;
      int area = 0;
      for (int i = 0; i < arr.length; i++) {
         width = (rb[i] - lb[i] - 1);
         area = arr[i] * width;
         if (area > max) {
            max = area;
         }
      }
      System.out.println(max);

   }
}