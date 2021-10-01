import java.util.*;
import java.io.*;

public class longest_consecutive_sequence_of_elements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        HashMap<Integer,Boolean>hmap=new HashMap<>();
        for (int key : a) {
            hmap.put(key, true);
        }
        for (int key : a) {
            if (hmap.containsKey(key-1)) {
                hmap.put(key, false);
            }
        }
        int ml=0;
        int msp=0;
        for (int key : a) {
            if (hmap.get(key)==true) {
                int totalLength=1;
                int trueStartingPoint=key;
                while (hmap.containsKey(trueStartingPoint+totalLength)) {
                    totalLength++;
                }
                if (totalLength>ml) {
                    ml=totalLength;
                    msp=trueStartingPoint;
                }
            }
        }
        for (int i = 0; i < ml; i++) {
            System.out.println(msp+i);
        }
    }
}
