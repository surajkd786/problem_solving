/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
*/
// import java.io.*;
import java.util.*;

public class  buyAndSellStocks_oneTransaction_Allowed{
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n=scn.nextInt();
int[] arr=new int[n];
for (int i = 0; i < arr.length; i++) {
    arr[i]=scn.nextInt();
}
int lsf=arr[0];
int pist=0;
int op=0;
for (int i = 1; i < arr.length; i++) {
    if(lsf>arr[i]){
        lsf=arr[i];
    }
    pist=arr[i]-lsf;
    if (pist>op) {
        op=pist;
    }
}
System.out.println(op);
    }
}