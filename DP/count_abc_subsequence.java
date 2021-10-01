/*1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
Input Format
A string str
// Output Format
count of subsequences of the nature a+b+c+
Question Video
Constraints
0 < str.length <= 10*/
import java.io.*;
import java.util.*;

public class count_abc_subsequence {
public static void main(String[] args) throws Exception {
// Scanner scn = new Scanner(System.in);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(count(str));

    }
    public static int count(String str) {
        int a=0;
        int ab=0;
        int abc=0;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch=='a') {
                a=2*a+1;
            }else if(ch=='b'){
                ab=2*ab+a;
            }else{
                abc=2*abc+ab;
            }
        }
        return abc;
    }
}
