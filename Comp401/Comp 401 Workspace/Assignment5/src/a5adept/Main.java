package a5adept;

import java.util.Scanner;

import a5adept.Adventure.Difficulty;

public class Main {

	public static void main(String[] args) {
		Knapsack arb_knap = new KnapsackImpl();
		Squad arb_squad = new SquadImpl(1,arb_knap);
		Scanner input_hardness = new Scanner(System.in);
		System.out.println("Select a difficulty level");
		Adventure new_adv = null;
		int difficulty = input_hardness.nextInt();
		if (difficulty == 1) {
			new_adv = new Adventure(Difficulty.EASY, arb_squad);
		} else if (difficulty == 2) {
			new_adv = new Adventure(Difficulty.MEDIUM, arb_squad);
		} else if (difficulty == 3) {
			new_adv = new Adventure(Difficulty.HARD, arb_squad);
		}
		int input;
		Scanner choose_city = new Scanner(System.in);
		while (true) {
			System.out.println("You are in " + new_adv.getCurrentCity().getName()
					+ ". Which city would you like to travel to?");
			for (int i = 0; i < new_adv.getCities().length; i++) {
				System.out.println(i + 1 + " " + new_adv.getCities()[i].getName());
			}
			input=choose_city.nextInt();
			if(input==0){
				break;
			}
			new_adv.travel(new_adv.getCities()[input-1]);
		}
		choose_city.close();
		input_hardness.close();
	}

}
