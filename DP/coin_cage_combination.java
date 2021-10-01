import java.io.*;
import java.util.*;

public class coin_cage_combination {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int combination = CCC_tab(arr, amt);
        System.out.println(combination);
    }

    public static int CCC_tab(int[] coins, int amt) {
        int []dp=new int[amt+1];
        dp[0]=1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i < dp.length; i++) {
                
                    if(i>=coins[j]){
                    int rem_amt=i-coins[j];
                    dp[i]+=dp[rem_amt];
                    }
                }
        }
        return dp[amt];
    }
}
