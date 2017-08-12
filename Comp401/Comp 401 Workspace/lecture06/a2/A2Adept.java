package a2;

import java.util.Scanner;

public class A2Adept {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process_input(s);
	}
	
	public static void process_input(Scanner s) {
		int input_Rect = s.nextInt(); //Initial input, how many rectangles the user wishes to give
		//String[] array_Rect= new String[input_Rect]; //Array of Strings constructed for each rectangle
		int counter = 0;
		int x1, x2, y1, y2, x, y, input_points;
		String l;
		Rectangle []Record = new Rectangle[input_Rect];
		for(int z= 0;z<input_Rect;z++){
			l = s.next();
			x1 = s.nextInt();
			y1 = s.nextInt();
			x2 = s.nextInt();
			y2 = s.nextInt();
			Rectangle nov_rec = new Rectangle(x1, y1, x2, y2, l);
			Record[z] = nov_rec;
		}
		input_points=s.nextInt();
		int [][]point_arr = new int[input_points][2];
		for(int i = 0;i<input_points;i++){
			point_arr[i][0] = s.nextInt();
			point_arr[i][1]= s.nextInt();
		}
		
		for(int k = 0; k<input_Rect;k++){
			for(int d = 0; d<input_points;d++){
				x = point_arr[d][0];
				y = point_arr[d][1];
				Point hold = new Point(x,y);
				if(Record[k].testPoint(hold)){
					counter++;
				}
			}
			System.out.println(Record[k].getLabel()+" contains "+counter+ " points");
			counter = 0;
		}
		
	}
}
