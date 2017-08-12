package a2;

import java.util.ArrayList;
import java.util.Scanner;

public class A2Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
		ArrayList<String> name_match = new ArrayList<String>();
		int numb_rec = s.nextInt();

		Rectangle []checker = new Rectangle[numb_rec];
		for (int i = 0; i < numb_rec; i++) {
			String l= s.next();
			int x1=s.nextInt();
			int y1=s.nextInt();
			int x2=s.nextInt();
			int y2=s.nextInt();
			checker[i] = new Rectangle(x1, y1, x2, y2, l);
		}
		
		for(int i = 0;i<numb_rec;i++){
			for(int k =0; k<numb_rec;k++){
				if(k!=i){
					if(checker[i].intersects(checker[k])){
						name_match.add(checker[k].getLabel());
					}
				}
			}
			
			String dummy_hold = "";
			if (name_match.size() > 0) {
				for (int z = 0; z < name_match.size(); z++) {
					dummy_hold += " " + name_match.get(z);
				}
			} else {
				dummy_hold = " nothing";
			}
			System.out.println(checker[i].getLabel() + " intersects" + dummy_hold);
			name_match.clear();

		}
	}
}
