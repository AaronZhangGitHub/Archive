package a1;
import java.util.Scanner;

public class A1Adept {
	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);

	       process(s);
	}

	public static void process(Scanner s) {

		//Rectangle input
		int input_Rect = s.nextInt();
		String[] array= new String[input_Rect];
		s.nextLine();
		for(int i = 0;i<input_Rect;i++){
			array[i]= s.nextLine();
		}

		//input points
		int input_points = s.nextInt();
		s.nextLine();
		String [] arr_points = new String[input_points];
		for(int j = 0; j<input_points;j++){
			arr_points[j] = s.nextLine();
		}
		
		
		int x1, x2, y1, y2, x, y;
		String rects;
		//finding out rectangle numbers
		int [] points_con = new int[input_Rect];
		
		String s1[]= new String[4];
		String s2[] = new String[2];
		String s3[] = new String[4];
		

		for(int k = 0; k<input_Rect;k++){
			s1 = array[k].split(" ");
			
			rects = s1[0];
			s3[k]=rects;
			
			x1 = Integer.parseInt(s1[1]);
			y1 = Integer.parseInt(s1[2]);
			x2 = Integer.parseInt(s1[3]);
			y2 = Integer.parseInt(s1[4]);
			
			
			
			
			for(int E=0;E<input_points;E++){
			s2 = arr_points[E].split(" ");
			x  = Integer.parseInt(s2[0]);
			y  = Integer.parseInt(s2[1]);

			if(x2>x1){
				if(y2>y1){
					if(x>x1&&x<x2&&y>y1&&y<y2){
						points_con[k]++;
					}
				}
				if(y1>y2){
					if(x>x1&&x<y2&&y<y1&&y>y2){
						points_con[k]++;
					}
				}
			}
			if(x1>x2){
				if(y2>y1){
					if(x<x1&&x>x2&&y>y1&&y<y2){
						points_con[k]++;
					}
				}
				if(y1>y2){
					if(x<x1&&x>x2&&y>y2&&y<y1){
						points_con[k]++;
					}
				}
			}
			}
			
			/*
			s2 = arr_points[k].split(" ");
			x  = Integer.parseInt(s2[0]);
			y  = Integer.parseInt(s2[1]);
			*/

	}
		for(int z = 0; z<input_Rect;z++){
			System.out.println(s3[z]+" contains " + points_con[z]+" points");
		}
	}
}
