import java.io.*;
import java.util.*;

public class goldmine {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
    int m=scn.nextInt();
    int n=scn.nextInt();
    int[][]gold=new int[m][n];
    for (int i = 0; i < gold.length; i++) {
        for (int j = 0; j < gold[0].length; j++) {
            gold[i][j]=scn.nextInt();
        }
    }
    // int qb[][] =new int[m][n];
    // int max=0;
    // for (int i = 0; i < gold.length; i++) {
    //     int ans=goldMine(gold,i,0,qb);
    //     if(ans>max){
    //         max=ans;
    //     }
    // }
    System.out.println(goldMine_tab(gold));

    }
    public static int goldMine_tab(int[][] gold) {
        int n=gold.length;
        int m=gold[0].length;
        int[][]dp=new int[n][m];
        for(int j=m-1;j>=0;j--){
            for (int i = 0; i < n; i++) {
                if (j==m-1) {
                    dp[i][j]=gold[i][j];
                }else if (i==0) {
                    dp[i][j]=Math.max(dp[i][j+1], dp[i+1][j+1])+gold[i][j];
                }
                else if (i==n-1) {
                    dp[i][j]=Math.max(dp[i][j+1], dp[i-1][j+1])+gold[i][j];
                }
                else{
                    dp[i][j]=Math.max(Math.max(dp[i-1][j+1], dp[i][j+1]),dp[i+1][j+1])+gold[i][j];
                }
            }
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        return max;     
    }
    // public static int goldMine(int[][] gold,int sr,int sc,int[][]qb) {
    //     if(sr<0||sr>=gold.length){
    //         return 0;
    //     }
    //     if(sc==gold[0].length-1){
    //         return gold[sr][sc];
    //     }
    //     if (qb[sr][sc]!=0) {
    //         return qb[sr][sc];
    //     }
    // int c1=goldMine(gold, sr-1, sc+1, qb);
    // int c2=goldMine(gold, sr, sc+1, qb);
    // int c3=goldMine(gold, sr+1, sc+1, qb);
    // int myAns=Math.max(Math.max(c1, c2), c3)+gold[sr][sc];
    // qb[sr][sc]=myAns;
    // return myAns;       
    // }
}