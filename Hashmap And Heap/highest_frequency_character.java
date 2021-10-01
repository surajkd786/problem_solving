import java.io.*;
import java.util.*;

public class highest_frequency_character {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> hm = new HashMap<>();
        String str = br.readLine();
        // putting keys and frequencies in hashmap
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                int of = hm.get(ch);
                int nf = of + 1;
                hm.put(ch, nf);
            } else {
                hm.put(ch, 1);
            }
        }
        Character mfc = str.charAt(0);
        for (Character key : hm.keySet()) {
            if (hm.get(key) > hm.get(mfc)) {
                mfc = key;
            }
        }
        System.out.println(mfc);
    }

}