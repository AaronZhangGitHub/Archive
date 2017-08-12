package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		int num_assignments = s.nextInt();
		int max_assignment_points = 0;
		for (int i=0; i<num_assignments; i++) {
			max_assignment_points += s.nextInt();
		}
		double num_recitations = 15.0;

		int num_students = s.nextInt();

		for (int i=0; i<num_students; i++) {
			String first_name = s.next();
			String last_name = s.next();
			int recitations_attended = s.nextInt();
			double assignment_total = 0.0;
			for (int a=0; a<num_assignments; a++) {
				assignment_total += s.nextDouble();
			}
			double recitation = map_percentage(recitations_attended/num_recitations);
			double assignments = map_percentage(assignment_total/max_assignment_points);

			double midterm1 = s.nextDouble();
			double midterm2 = s.nextDouble();
			double final_exam = s.nextDouble();

			double weighted_avg = 0.4 * assignments + 
					0.1 * recitation +
					0.15 * midterm1 +
					0.15 * midterm2 +
					0.2 * final_exam;
			System.out.println(first_name.charAt(0) + ". " + last_name + " " + map_to_letter_grade(weighted_avg));
		}
	}


	public static double map_percentage(double p) {
		if (p >= 0.95) {
			return 4.0;
		} else if (p >= 0.7) {
			return (p - 0.7)*10.0 + 1.5;
		} else if (p >= 0.4) {
			return (p-0.4)*5.0;
		} else {
			return 0.0;
		}
	}
	
	public static String map_to_letter_grade(double weighted_avg) {
		if (weighted_avg >= 3.85) {
			return "A";
		} else if (weighted_avg >= 3.5) {
			return "A-";
		} else if (weighted_avg >= 3.15) {
			return "B+";
		} else if (weighted_avg >= 2.85) {
			return "B";
		} else if (weighted_avg >= 2.5) {
			return "B-";
		} else if (weighted_avg >= 2.15) {
			return "C+";
		} else if (weighted_avg >= 1.85) {
			return "C";
		} else if (weighted_avg >= 1.5) {
			return "C-";
		} else if (weighted_avg >= 1.15) {
			return "D+";
		} else if (weighted_avg >= 0.85) {
			return "D";
		} else {
			return "F";
		}
	}	


}
