import java.io.*;
import java.util.*;

public class buy_AndSellStocks_with_transaction_fee {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        int obsp = -arr[0];
        int ossp = 0;
        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            if (obsp < ossp - arr[i]) {
                nbsp = ossp - arr[i];
            } else {
                nbsp = obsp;
            }
            if (ossp < obsp + arr[i] - fee) {
                nssp = obsp + arr[i] - fee;
            }else{
                nssp=ossp;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        System.out.println(ossp);

    }
}
