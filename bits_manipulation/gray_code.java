import java.util.*;

public class gray_code {

    public static ArrayList<String> grayCode(int n) {
        // Write your code here
        if (n == 1) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        ArrayList<String> rres = grayCode(n - 1);
        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < rres.size(); i++) {
            String rstr = rres.get(i);
            mres.add("0" + rstr);
        }
        for (int i = rres.size() - 1; i >= 0; i--) {
            String rstr = rres.get(i);
            mres.add("1" + rstr);
        }
        return mres;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> ans = grayCode(scn.nextInt());
        Collections.sort(ans);
        System.out.println(ans);
    }
}