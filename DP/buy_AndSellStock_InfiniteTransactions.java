
/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)*/
import java.io.*;
import java.util.*;

public class buy_AndSellStock_InfiniteTransactions {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int bd = 0;
        int sd = 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                sd++;
            } else {
                profit += arr[sd] - arr[bd];
                bd = sd = i;
            }
        }
        profit += arr[sd] - arr[bd];
        System.out.println(profit);
    }
}