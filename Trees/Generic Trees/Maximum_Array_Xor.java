import java.io.*;
import java.util.*;

class Maximum_Array_Xor {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            long num = (long) Math.pow(2, n);
            long sum = 0;
            long l = 0;
            for (int j = 0; j < k; j++) {
                sum += (j ^ (num - 1 - l)) * 2;
                l++;
            }
            System.out.println(sum);

        }
    }
}