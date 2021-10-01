
import java.util.*;

public class get_common_elements_1 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> fhm = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            if (fhm.containsKey(a1[i])) {
                int of = fhm.get(a1[i]);
                int nf = of + 1;
                fhm.put(a1[i], nf);
            } else {
                fhm.put(a1[i], 1);
            }
        }
        for (int key : a2) {
            if (fhm.containsKey(key)) {
                System.out.println(key);
                fhm.remove(key);
            }
        }
    }

}
