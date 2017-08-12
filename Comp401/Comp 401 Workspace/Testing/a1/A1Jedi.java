package a1;
import java.util.ArrayList;
import java.util.Scanner;

public class A1Jedi {
	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);

	       process(s);
	}

	public static void process(Scanner s) {
	       /* Here is where your code will go. */
		int num_rect = s.nextInt(); //takes the number of rectangle
		s.nextLine();
		String [] name = new String[num_rect]; // constructs an array to take in the rectangle name
		String S1[]; //Array used to split lines
		String S2[];
		ArrayList<String> name_match = new ArrayList<String>(); //maybe delete
		int bot_rX, bot_rY, top_LX,top_LY;
		int bot_rX1, bot_rY1, top_LX1,top_LY1;
		int Check[][]=new int[4][4];//may need to delete
		String name_check;
		int rect_coord[][] = new int[4][4];
		//ArrayList<String> name_match = new ArrayList<String>();
		//ArrayList<Integer>num_match = new ArrayList<Integer>();
		
		//Takes user input 
		String []inp = new String[num_rect];
		for(int i = 0;i<num_rect;i++){
			inp[i]=s.nextLine();
		}
		//assigns what the user inputs
		for(int i = 0; i<num_rect;i++){

			S1 = inp[i].split(" "); //splits the input at each space
			name[i]=S1[0];
			rect_coord[0][0]=Integer.parseInt(S1[1]);
			rect_coord[0][1]=Integer.parseInt(S1[2]);
			rect_coord[1][0]=Integer.parseInt(S1[3]);
			rect_coord[1][1]=Integer.parseInt(S1[4]);
			
			bot_rX = bottomRX(rect_coord);//bottom right X coordinate
			bot_rY = bottomRY(rect_coord);//bottom right Y coordinate
			top_LX = topLX(rect_coord);//top left X coordinate
			top_LY = topLY(rect_coord);//top left Y coordinate
			
			//System.out.println("a"+ i+"i "+bot_rX+" "+bot_rY+" "+top_LX+" "+top_LY); //test
			for(int k = 0; k<num_rect;k++){
				if(i!=k){	
					S2 = inp[k].split(" ");//working around here 
					//problem finding out how to output which rectangle matches which
					name_check = S2[0];
					Check[0][0]=Integer.parseInt(S2[1]);
					Check[0][1]=Integer.parseInt(S2[2]);
					Check[1][0]=Integer.parseInt(S2[3]);
					Check[1][1]=Integer.parseInt(S2[4]);
					/*
					System.out.println(Check[0][0]);
					System.out.println(Check[0][1]);
					System.out.println(Check[1][0]);
					System.out.println(Check[1][1]);
					*/
					bot_rX1 = bottomRX(Check);//bottom right X coordinate
					bot_rY1 = bottomRY(Check);//bottom right Y coordinate
					top_LX1 = topLX(Check);//top left X coordinate
					top_LY1 = topLY(Check);//top left Y coordinate
					
					
					//System.out.println(k+" "+bot_rX1+" "+bot_rY1+" "+top_LX1+" "+top_LY1); //test
					if((top_LX1>=bot_rX)||(top_LX>=bot_rX1)){
						//not in
					}
					else if((bot_rY1>=top_LY)||(top_LY1<=bot_rY)){
						//not in
					}
					else{
						//inside
						name_match.add(name_check);
						//System.out.println(name[i]+ " " +name_check); //used for checking
						//System.out.println("yes");
					}
				}
			}
			String dummy_hold= "";
			if(name_match.size()>0){
			for(int z= 0; z<name_match.size();z++){
				//System.out.println(name_match.size());
				dummy_hold+=" "+name_match.get(z);
				//System.out.println(name_match.get(z));
			}
			}
			else{
				dummy_hold = " nothing";
			}
			System.out.println(name[i] + " intersects"+dummy_hold);
			name_match.clear();
			
		}
		
		
	}
	public static int topLY(int rect_coord[][]){
		int topLY=0;
		if(rect_coord[0][1]>rect_coord[1][1]){
			topLY = rect_coord[0][1];
		}
		else{
			topLY = rect_coord[1][1];
		}
		return topLY;
	}
	public static int topLX(int rect_coord[][]){
		int topLX=0;
		if(rect_coord[1][0]<rect_coord[0][0]){
			topLX = rect_coord[1][0];
		}
		else {
			topLX = rect_coord[0][0];
		}
		return topLX;
	}
	public static int bottomRY(int rect_coord[][]){
		//find bottom right y coordinate
		int bot_rY = 0;
		
		if(rect_coord[0][1]>rect_coord[1][1]){
			bot_rY = rect_coord[1][1];
		}
		else{
			bot_rY = rect_coord[0][1];
		}
		return bot_rY;
	}
	public static int bottomRX(int rect_coord[][]){
		//find bottom right x coordinate
		int br=0;
		if((rect_coord[0][1]>rect_coord[1][1])&&(rect_coord[0][0]>rect_coord[1][0])){
			br= rect_coord[0][0];}
		else if((rect_coord[1][1]>rect_coord[0][1])&&(rect_coord[0][0]>rect_coord[1][0])){
			br= rect_coord[0][0];
		}
		else{
			br = rect_coord[1][0];
		}

		return br;
	}
}