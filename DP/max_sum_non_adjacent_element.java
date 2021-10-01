// import java.io.*;
import java.util.*;

public class max_sum_non_adjacent_element {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n=scn.nextInt();
int[] arr=new int[n];
for (int i = 0; i < arr.length; i++) {
    arr[i]=scn.nextInt();
}
System.out.println(Max(arr));

}
    public static int Max(int[] arr) {
        int inc=arr[0];
        int exc=0;
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            int ninc=arr[i]+exc;
            int nexc=Math.max(inc, exc);
            exc=nexc;
            inc=ninc;
        }
        return Math.max(inc, exc);
    }
}