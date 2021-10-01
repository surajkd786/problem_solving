import java.io.*;
import java.util.*;

public class number_of_vali_words {

	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		//write your code here
		
		return null;
	 }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
		for(int val : ans) {
			System.out.println(puzzles[val] + " -> " + ans.get(val));
		}
	}
	
}