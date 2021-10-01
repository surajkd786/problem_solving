import java.util.*;

// import jdk.nashorn.internal.parser.Scanner;
/**
 * fiboWithDP
 */
 class fiboWithDP {
     //memoisation
// public static void main(String[] args)throws Exception {
//     Scanner sc=new Scanner(System.in);
//     int n=scn.nextInt();
//     int[]qb=new int[n+1];
//     Arrays.fill(qb, -1);
//     int nth=fiboWithDP(n,qb);
//     System.out.println(nth);
// }
// public static int fiboWithDP(int n,int[] qb) {
//     if(n==0||n==1){
//         return n;
//     }
//     if(qb[n]!=-1){
//         return qb[n];
//     }
//     int fibn=fiboWithDP(n-1,qb)+fiboWithDP(n-2,qb);
//     qb[n]=fibn;
//     return fibn;

// }
//tabulation
public static void main(String[] args)throws Exception {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    int nth=fiboWithDP(n);
    System.out.println(nth);
}
public static int fiboWithDP(int n) {
   
    int[] dp=new int[n+1];
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<=n;i++){
    dp[i]=dp[i-1]+dp[i-2];
    }
    
    return dp[n];

}

    
}