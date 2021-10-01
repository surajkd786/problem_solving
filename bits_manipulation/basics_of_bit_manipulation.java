import java.io.*;
import java.util.*;

public class basics_of_bit_manipulation {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here.
    int on_mask=(1<<i);
    int off_mask=~(1<<j);
    int toggle_mask=(1<<k);
    int check_mask=(1<<m);

    System.out.println(n| on_mask);
    System.out.println(n& off_mask);
    System.out.println(n^ toggle_mask);
    System.out.println((n& check_mask)==0?false:true);
  }

}