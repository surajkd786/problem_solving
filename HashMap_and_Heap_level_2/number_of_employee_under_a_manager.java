import java.io.*;
import java.util.*;

public class number_of_employee_under_a_manager {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), br.readLine());
        }
        findCount(map);

    }
    public static void findCount(HashMap<String, String> map){
        HashMap<String,HashSet<String>> tree=new HashMap<>();
        String ceo="";
        for (String emp : map.keySet()) {
            String man=map.get(emp);
            if (man.equals(emp)) {
                ceo=man; 
            }else {
                if (map.containsKey(man)) {
                    HashSet<String> emps=map.get(man);
                    emps.add(emp); 
                }else{
                    HashMap 
                }
            }
        }
    }
}