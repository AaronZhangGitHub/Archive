package a2;

import java.util.Scanner;

public class A2Novice {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process_input(s);
	}
	
	public static void process_input(Scanner s) {
		int total_rect = s.nextInt();
		String l;
		int x1, y1, x2, y2;
		int tall = 0;
		int wide = 0;
		int square = 0;
		int min_Area = 2147483647, max_Area = 0, min_per = 2137483647, max_per = 0;
		String areamax = null, areamin = null,perimmax = null,perimmin = null;
		for(int i = 0; i<total_rect; i++){
			l = s.next();
			x1 = s.nextInt();
			y1 = s.nextInt();
			x2 = s.nextInt();
			y2 = s.nextInt();

			Rectangle nov_rec = new Rectangle(x1,y1,x2,y2,l);
			
			if(nov_rec.isTall()){
				tall++;
			}
			if(nov_rec.isWide()){
				wide++;
			}
			if(nov_rec.isSquare()){
				square++;
			}
			//
			if(nov_rec.getPerimeter()>max_per){
				max_per = nov_rec.getPerimeter();
				perimmax = nov_rec.getLabel();
			}
			if(nov_rec.getPerimeter()<min_per){
				min_per = nov_rec.getPerimeter();
				perimmin = nov_rec.getLabel();
			}

			if(nov_rec.getArea()>max_Area){
				max_Area = nov_rec.getArea();
				areamax = nov_rec.getLabel();
			}
			if(nov_rec.getArea()<min_Area){
				min_Area = nov_rec.getArea();
				areamin = nov_rec.getLabel();
			}
			//
		}
		System.out.println("Square count = "+square);
		System.out.println("Wide count = "+ wide);
		System.out.println("Tall count = "+tall);
		System.out.println("Min perimeter = "+min_per+ " ("+perimmin+")");
		System.out.println("Max perimeter = "+ max_per+ " ("+perimmax+")");
		System.out.println("Min area = "+min_Area + " ("+areamin+")");
		System.out.println("Max area = "+max_Area + " ("+areamax+")");
	}
}
