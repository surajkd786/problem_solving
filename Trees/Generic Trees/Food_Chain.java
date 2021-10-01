import java.io.*;
import java.util.*;

class Food_Chain {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
    int t=scn.nextInt();
    for (int i=0;i<t;i++) {
        int n=scn.nextInt();
        int k=scn.nextInt();
        int count=1;
        while (Math.floor(n/k)!=0) {
            n=(int)Math.floor(n/k);
            count++;
        }
        System.out.println(count);;
    }
    }
}