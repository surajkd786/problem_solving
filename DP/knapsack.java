// import java.io.*;
import java.util.*;

public class knapsack{
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n=scn.nextInt();
int[] val=new int[n];
int[] wt=new int[n];
for (int i = 0; i < n; i++) {
    val[i]=scn.nextInt();
}
for (int i = 0; i < n; i++) {
    wt[i]=scn.nextInt();
}
int cap=scn.nextInt();
int zok=ZeroOneKnapsack(val,wt,cap);
System.out.println(zok);
}
public static int ZeroOneKnapsack(int[]val,int[]wt,int cap) {
    int[][] dp=new int[val.length][cap+1];
    for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {    
                if(i==0){
                    if(j>=wt[i]){
                    dp[i][j]=val[i];
                    }else{
                        
                    }
                    
                }else if(j==0){
                    dp[i][j]= 0;
                }else{
                    int prevVal=dp[i-1][j];
                    int newVal=0;
                    if(j>=wt[i]){
                        newVal=dp[i-1][j-wt[i]]+val[i];
                    }
                    dp[i][j]=Math.max(prevVal, newVal);
                }
            }
    }
    return dp[val.length-1][cap];
}
}
