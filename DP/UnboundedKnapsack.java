import java.util.*;

public class UnboundedKnapsack{
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
int zok=unBounded_Knapsack(val,wt,cap);
System.out.println(zok);
}
public static int unBounded_Knapsack(int[]val,int[]wt,int cap) {
    int[] dp=new int[cap+1];
    dp[0]=0;
    for (int i = 1; i < dp.length; i++) {
        for (int j = 0; j < wt.length; j++) {
            int max=0;
            if(i>=wt[j]){
                int rBagWt=i-wt[j];
                max=dp[rBagWt]+val[j];
                if(dp[i]<max){
                    dp[i]=max;
                }

            }
        }
        
    }
    return dp[cap] ;
}
}
