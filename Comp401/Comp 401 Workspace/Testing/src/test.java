
public class test {
public static void main(String args[]){
	int bot_rX= 10;
	int top_LX =0 ;
	int top_LY=0;
	int bot_rY=10;
	
	int top_LX1=15;
	int bot_rX1=20;
	int bot_rY1= 15;
	int top_LY1=30;
	
	if((top_LX1>=bot_rX)&&(top_LX>=bot_rX1)){
		//not in
		System.out.println("true");
	}
	else if((bot_rY1>=top_LY)&&(top_LY1<=bot_rY)){
		//not in
		System.out.println("true1");
	}
}
}
