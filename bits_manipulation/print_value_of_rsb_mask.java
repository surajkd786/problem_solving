import java.io.*;
import java.util.*;

public class print_value_of_rsb_mask {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rsb = n & -n;
        System.out.println(Integer.toBinaryString(rsb));

    }
}