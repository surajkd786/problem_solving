// import java.io.*;
import java.util.*;

public class Target_sum_subset {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    int[]arr=new int[n];
    for (int i = 0; i < n; i++) {
        arr[i]=scn.nextInt();
    }
    int tar=scn.nextInt();
    System.out.println(targetSumSub(arr,tar));
    }
public static boolean targetSumSub(int[]arr,int tar) {
    int n=arr.length;

    boolean[][] dp=new boolean[n+1][tar+1];
    for (int i = 0; i < n+1; i++) {
        for (int j = 0; j < tar+1; j++) {
            if (i==0&&j==0) {
                dp[i][j]=true;
            }
            else if (j==0) {
                dp[i][j]=true;
            }
            else if (i==0) {
                dp[i][j]=false;
            }else{
                if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }else{
                    int val=arr[i-1];
                    if(j>=val){
                        if (dp[i-1][j-val]==true) {
                            dp[i][j]=true;
                        }
                    }
                }
            }
        }
    }
    return dp[arr.length][tar];
}
}
