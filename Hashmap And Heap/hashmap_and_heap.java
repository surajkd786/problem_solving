// import java.io.*;
import java.util.*;

public class hashmap_and_heap {
public static void main(String[] args) throws Exception {
        HashMap<String,String> hm=new HashMap<>();
        hm.put("name","suraj kumar dev" );
        hm.put("roll", "204ca051");
        hm.put("college", "NITK");
        hm.put("lives", "katihar");
        System.out.println(hm);
        hm.put("lives", "Banglore");
        System.out.println(hm);
        System.out.println(hm.get("name"));
        System.out.println(hm.get("jdk"));//returns null
        System.out.println(hm.containsKey("name"));
        System.out.println(hm.containsKey("k"));
        Set<String> keys=hm.keySet();
        System.out.println(keys);
        for (String key : hm.keySet()) {
            String ch=hm.get(key);
            System.out.println(ch);
        }
    }
}