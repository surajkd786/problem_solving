import java.io.*;
import java.util.*;

public class buy_AndSellStock_Two_Transaction_Allowed {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        // for left to right trasactions
        int mpist = 0;
        int leastsf = arr[0];
        int[] dpl = new int[arr.length];
        for (int i = 1; i < dpl.length; i++) {
            if (leastsf > arr[i]) {
                leastsf = arr[i];
            }
            mpist = arr[i] - leastsf;
            if (mpist > dpl[i]) {
                dpl[i] = mpist;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }

        //for right to left transaction
        int mpibt=0;
        int maxat=arr[arr.length-1];
        int [] dpr=new int[arr.length];
        for (int i = arr.length-2; i >=0; i--) {
            if(maxat<arr[i]){
                maxat=arr[i];
            }
            mpibt=maxat-arr[i];
            if (mpibt>dpr[i+1]) {
                dpr[i]=mpibt;     
            }else{
                dpr[i]=dpr[i+1];
            }
        }
        int op=0;
        for (int i = 0; i < dpr.length; i++) {
            if (dpl[i]+dpr[i]>op) {
                op=dpl[i]+dpr[i];
                
            }
        }
        System.out.println(op);
    }
}
