package a1;
import java.util.Scanner;

public class A1Novice {
	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);

	       process(s);
	}

	public static void process(Scanner s) {
		String rectname,  areamax = null, areamin = null,perimmax = null,perimmin = null;
		int fcorn1, fcorn2, scorn1, scorn2;
		int widec = 0,tallc=0,minp=2147483647,maxp=0,mina=2147483647,maxa=0,sqcnt=0,perim=0,areea=0, width=0,height=0;
		//String [] s1;
	       /* Here is where your code will go. */
		int total_rect = s.nextInt();
		for(int i = 0; i<total_rect; i++)
		{
			//lines = s.nextLine();
			//s1 = lines.split(" ");
			rectname = s.next();
			fcorn1 = s.nextInt();
			fcorn2 = s.nextInt();
			scorn1 = s.nextInt();
			scorn2 = s.nextInt();
			
			width = Math.abs(fcorn1-scorn1);
			height = Math.abs(fcorn2-scorn2);

			if(width>height){
				widec +=1;
			}
			else if(height>width){
				tallc+=1;
			}
			else{
				sqcnt+=1;
			}
			
			perim = 2*width+2*height;
			areea = width*height;
			
			if(perim>maxp){
				maxp = perim;
				perimmax = rectname;
			}
			if(perim<minp){
				minp = perim;
				perimmin = rectname;
			}

			if(areea>maxa){
				maxa = areea;
				areamax = rectname;
			}
			if(areea<mina){
				mina = areea;
				areamin = rectname;
			}
			
			if(i==total_rect-1){
				System.out.println("Square count = "+sqcnt);
				System.out.println("Wide count = "+ widec);
				System.out.println("Tall count = "+tallc);
				System.out.println("Min perimeter = "+minp+ " ("+perimmin+")");
				System.out.println("Max perimeter = "+ maxp+ " ("+perimmax+")");
				System.out.println("Min area = "+mina + " ("+areamin+")");
				System.out.println("Max area = "+maxa + " ("+areamax+")");
			}
			
		}
		
	}
			
			/*
			System.out.println(rectname);
			System.out.println(fcorn1);
			System.out.println(scorn1);
			*/

		
			
			
}
