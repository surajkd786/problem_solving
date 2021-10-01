import java.io.*;
import java.util.*;

class Ceiling_Sum {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int A = scn.nextInt();
            int B = scn.nextInt();
            int X = 0;
            if (A == B) {
                X = A;

            } else if (A > B) {
                X = (B / 2) - 1;
            } else {
                X = A + ;
            }
            int ans = (int) (Math.ceil((B - X) / 2) + Math.ceil((X - A) / 2));
            System.out.println(ans);
        }
    }
}