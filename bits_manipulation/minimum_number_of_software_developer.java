import java.io.*;
import java.util.*;

// A number N representing number of required skills
// N space separated strings 
// A number M representing number of applicants
// For every applicant : A number T representing number of skills of an applicant and then T number of space separated strings.

public class minimum_number_of_software_developer {

	static ArrayList<Integer> sol = new ArrayList<>();

	public static void solution(int[] people, int num_of_skills, int current_person, ArrayList<Integer> onesol, int skill_mask_of_SE) {
		// write your code here
		if (current_person == people.length) {
			if (skill_mask_of_SE == ((1 << num_of_skills) - 1)) {
				if (sol.size() == 0 || sol.size() > onesol.size()) {
					sol = new ArrayList<>(onesol);
				}
			}
			return;
		}
		solution(people, num_of_skills, current_person + 1, onesol, skill_mask_of_SE);// no
		onesol.add(current_person);// add while going into recursion
		solution(people, num_of_skills, current_person + 1, onesol, (skill_mask_of_SE | people[current_person]));// yes
		onesol.remove(onesol.size() - 1);// removing while coming out of the recursion

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}

		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);

	}
}
