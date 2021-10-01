import java.io.*;
import java.util.*;

public class count_binary_strings {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    int countOfBinaryStrings=countString(n);
    System.out.println(countOfBinaryStrings);
    }
    public static int countString(int n) {
       int cones=1;
       int czeros=1;
       for (int i = 1; i < n; i++) {
           int nzeros=cones;
           int nones=cones+czeros;
           cones=nones;
           czeros=nzeros;

       }
        return cones+czeros;
        
    }
}