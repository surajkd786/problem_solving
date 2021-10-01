/*1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.*/
// import java.io.*;
import java.util.*;

public class paint_house_many_colors {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n = scn.nextInt();
int k=scn.nextInt();
int[][] arr = new int[n][k];
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < k; j++) {
        arr[i][j] = scn.nextInt();
    }

}
System.out.println(MinCost(arr));
}
public static int MinCost(int[][] arr) {
    int [][] dp=new int[arr.length][arr[0].length];
    int Least=Integer.MAX_VALUE;
    int sLeast=Integer.MAX_VALUE;
    for (int i = 0; i < dp[0].length; i++) {
        dp[0][i]=arr[0][i];
        if (dp[0][i]<=Least) {
            sLeast=Least;
            Least=dp[0][i];
        }else if(dp[0][i]<=sLeast){
            sLeast=dp[0][i];
        }
    }
    for (int i = 1; i < dp.length; i++) {
        int nLeast=Integer.MAX_VALUE;
        int nsLeast=Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[i-1][j]==Least) {
                dp[i][j]=sLeast+arr[i][j];
            }else{
                dp[i][j]=Least+arr[i][j];
            }
            if (dp[i][j]<=nLeast) {
                nsLeast=nLeast;
                nLeast=dp[i][j];
            }else if(dp[i][j]<=nsLeast){
                nsLeast=dp[i][j];
            }
        }
        Least=nLeast;
        sLeast=nsLeast;
        
    }
    
    return Least;
}
}