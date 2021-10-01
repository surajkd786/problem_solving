import java.io.*;
import java.util.*;

public class arrange_Buildings {
public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
long n=scn.nextInt();
System.out.println(arrangment(n));

    }
    public static long arrangment(long n) {
        long countBuildings=1;
        long countSpaces=1;
        for (int i = 1; i < n; i++) {
            long newBC=countSpaces;
            long newSC=countSpaces+countBuildings;
            countSpaces=newSC;
            countBuildings=newBC;
        }
        return (countBuildings+countSpaces)*(countBuildings+countSpaces);
    }
}