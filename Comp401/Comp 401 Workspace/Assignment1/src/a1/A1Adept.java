package a1;
import java.util.Scanner;

public class A1Adept {
	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);

	       process(s);
	}

	public static void process(Scanner s) {
		int input_rec = s.nextInt();
		int counter = 0;
		int input_points;
		int[] x1 = new int [input_rec];
		int[] x2 = new int [input_rec];
		int[] y1 = new int [input_rec];
		int[] y2 = new int [input_rec];
		int x1h, x2h, y1h, y2h;
		String[] l = new String [input_rec];

		for(int z= 0;z<input_rec;z++){
			l[z] = s.next();
			x1h = s.nextInt();
			y1h = s.nextInt();
			x2h = s.nextInt();
			y2h = s.nextInt();
			x1[z]= Math.min(x1h, x2h);
			x2[z]= Math.max(x1h, x2h);
			y1[z]= Math.min(y1h, y2h);
			y2[z]= Math.max(y1h, y2h);
		}
		input_points=s.nextInt();
		int [][]point_arr = new int[input_points][2];
		for(int i = 0;i<input_points;i++){
			point_arr[i][0] = s.nextInt();
			point_arr[i][1]= s.nextInt();
		}
		
		for(int k = 0;k<input_rec;k++){
			for(int i = 0;i<input_points;i++){
				int x = point_arr[i][0];
				int y = point_arr[i][1];
				//System.out.println(x+" "+y);
				//System.out.println(x1[k]+" "+y1[k]+" "+x2[k]+" "+y2[k]);
				if(x>x1[k]&&x<x2[k]&&y>y1[k]&&y<y2[k]){
					counter +=1;
				}
			}
			System.out.println(l[k]+" contains "+counter+" points");
			counter =0;
		}
		
		/*
		 * 	public boolean testPoint(Point p) {
		int x = p.getX();
		int y = p.getY();
		int maxX = this.upper_right.getX();
		int minX = this.bottom_left.getX();
		int maxY = this.upper_right.getY();
		int minY = this.bottom_left.getY();
		
		if((x>minX)&&(x<maxX)&&(y>minY)&&(y<maxY)){
			return true;
		}
		else
			return false;
	}
		 */
	}
}
