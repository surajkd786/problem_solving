import java.io.*;
import java.util.*;

public class coin_cage_permutation {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int[] qb=new int[amt+1];
        // int permutations = CCP_mem(arr, amt,qb);
        int permutations = CCP_tab(arr, amt);
        System.out.println(permutations);
    }
    public static int CCP_tab(int[] coins,int amt) {
        int[] dp=new int[amt+1];
        dp[0]=1;
        for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if(i>=coins[j]){
                    int rem_amt=i-coins[j];
                    dp[i]+=dp[rem_amt];
                    }
                }
        }
        return dp[amt];
    }

    public static int CCP_mem(int[] arr, int amt,int[] qb) {
        int sum=0;
        if(amt==0){
            return 1;
        }
        if (qb[amt]!=0) {
            return qb[amt];
        }
        for (int i = 0; i < arr.length; i++) {
            int rem_amt=amt-arr[i];
            if(rem_amt>=0){
            sum=sum+CCP_mem(arr,rem_amt,qb);
            qb[amt]=sum;
            }
        }
        return sum;
    }
}