import java.io.*;
// import java.util.*;

public class josephus_special {
    public static int power(int n){
        int pow=1;
        while(2*pow<=n){
            pow=2*pow;
        }
        return pow;
    }

  public static int solution(int n){
    //write your code here
    int pow2h=power(n);
    int l=n-pow2h;
    
    return 2*l+1;
  }

    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

}
