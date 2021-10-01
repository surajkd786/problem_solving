import java.io.*;
import java.util.*;

public class merge_overlapping_intervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs=new Pair[arr.length];//creating pair
        //pushing elements into pairs
        for (int i = 0; i < arr.length; i++) {
            pairs[i]=new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);//sorting object of pairs
        Stack<Pair>st=new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if(i==0){
                st.push(pairs[i]);
            }else{
                Pair top=st.peek();
                Pair curr=pairs[i];
                if(curr.st>top.et){
                    st.push(curr);
                }else{
                    top.et=Math.max(curr.et,top.et);
                }
            }
        }
        //copying tha data of one stack into another
        Stack<Pair>res=new Stack<>();
        while (st.size()>0) {
            res.push(st.pop());
        }
        while (res.size()>0) {
            Pair p=res.pop();
            System.out.println(p.st+" "+p.et);
        }
    }
    
    public static class Pair implements Comparable <Pair> {
        int st;
        int et; 
        public Pair(int st,int et){
            this.st=st;
            this.et=et;
        }
        public int compareTo(Pair other){
            if (this.st!=other.st) {
                return this.st-other.st;
            }else{
                return this.et-other.et;
            }
        }
    }
}