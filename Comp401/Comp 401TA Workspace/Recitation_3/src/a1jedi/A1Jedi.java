package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print(curve_exam(72,48.65 ,9.0));
		//process(s);

	}

	public static void process(Scanner s) {
		int num_assignments = s.nextInt();
		int max_assignment_points = 0;
		for (int i=0; i<num_assignments; i++) {
			max_assignment_points += s.nextInt();
		}
		double num_recitations = 15.0;

		int num_students = s.nextInt();

		double[] recitation = new double[num_students];
		double[] assignments = new double[num_students];
		int[] midterm1_raw = new int[num_students];
		int[] midterm2_raw = new int[num_students];
		int[] final_raw = new int[num_students];
		
		for (int i=0; i<num_students; i++) {
			String first_name = s.next();
			String last_name = s.next();
			
			int recitations_attended = s.nextInt();

			double assignment_total = 0.0;
			for (int a=0; a<num_assignments; a++) {
				assignment_total += s.nextDouble();
			}

			recitation[i] = map_percentage(recitations_attended/num_recitations);
			assignments[i] = map_percentage(assignment_total/max_assignment_points);

			midterm1_raw[i] = s.nextInt();
			midterm2_raw[i] = s.nextInt();
			final_raw[i] = s.nextInt();
		}
		
		double midterm1_avg = calc_exam_average(midterm1_raw);
		double midterm1_sd = calc_exam_sd(midterm1_raw, midterm1_avg);
		double midterm2_avg = calc_exam_average(midterm2_raw);
		double midterm2_sd = calc_exam_sd(midterm2_raw, midterm2_avg);
		double final_avg = calc_exam_average(final_raw);
		double final_sd = calc_exam_sd(final_raw, final_avg);

		int a_count = 0;
		int aminus_count = 0;
		int bplus_count = 0;
		int b_count = 0;
		int bminus_count = 0;
		int cplus_count = 0;
		int c_count = 0;
		int cminus_count = 0;
		int dplus_count = 0;
		int d_count = 0;
		int f_count = 0;

		for (int i=0; i<num_students; i++) {
			double midterm1 = curve_exam(midterm1_raw[i], midterm1_avg, midterm1_sd);
			double midterm2 = curve_exam(midterm2_raw[i], midterm2_avg, midterm2_sd);
			double final_exam = curve_exam(final_raw[i], final_avg, final_sd);
		
			double weighted_avg = 0.4 * assignments[i] + 
					0.1 * recitation[i] +
					0.15 * midterm1 +
					0.15 * midterm2 +
					0.2 * final_exam;
			
			switch (map_to_letter_grade(weighted_avg)) {
			case "A": a_count++; break;
			case "A-": aminus_count++; break;
			case "B+": bplus_count++; break;
			case "B": b_count++; break;
			case "B-": bminus_count++; break;
			case "C+": cplus_count++; break;
			case "C": c_count++; break;
			case "C-": cminus_count++; break;
			case "D+": dplus_count++; break;
			case "D": d_count++; break;
			case "F": f_count++; break;
			}
		}
		
		System.out.println("A : " + a_count);
		System.out.println("A-: " + aminus_count);
		System.out.println("B+: " + bplus_count);
		System.out.println("B : " + b_count);
		System.out.println("B-: " + bminus_count);
		System.out.println("C+: " + cplus_count);
		System.out.println("C : " + c_count);
		System.out.println("C-: " + cminus_count);
		System.out.println("D+: " + dplus_count);
		System.out.println("D : " + d_count);
		System.out.println("F : " + f_count);
	}


	private static double curve_exam(int raw, double avg, double sd) {
		double normalized = (raw - avg) / sd;
		if (normalized >= 1.0) {
			return 4.0;
		}
		if (normalized >= -1.0) {
			return (normalized + 3.0);
		}
		if (normalized >= -2.0) {
			return normalized * 2.0 + 4.0;
		}
		return 0.0;
	}

	private static double calc_exam_sd(int[] raw, double avg) {
		double square_sum = 0.0;
		for (int i=0; i<raw.length; i++) {
			square_sum += (raw[i] - avg) * (raw[i] - avg);
		}
		return Math.sqrt(square_sum/raw.length);
	}

	private static double calc_exam_average(int[] raw) {
		double sum = 0.0;
		for (int i=0; i<raw.length; i++) {
			sum += raw[i];
		}
		return sum / raw.length;
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
