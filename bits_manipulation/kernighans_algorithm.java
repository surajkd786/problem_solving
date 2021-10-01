import java.io.*;
import java.util.*;

public class kernighans_algorithm {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n != 0) {
            int rsbm = n & -n;
            n = n - rsbm;
            count++;
        }
        System.out.println(count);
    }
}