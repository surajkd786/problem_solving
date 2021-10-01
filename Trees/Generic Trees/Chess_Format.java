import java.io.*;
import java.util.*;

 class Chess_Format {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            if (n + k < 3) {
                System.out.println("1");
            } else if (n + k >= 3 && n + k <= 10) {
                System.out.println("2");
            } else if (n + k >= 11 && n + k <= 60) {
                System.out.println("3");
            } else if (n + k > 60) {
                System.out.println("4");
            }
        }
    }
}