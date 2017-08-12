package a7;

import java.util.Scanner;

import supplies.BisonJerky;
import supplies.Coffee;
import a7.Adventure.Difficulty;

// main class game loop
public class Main {

	// declare private variables
	private static Adventure adventure;
	private static Squad squad;
	
	private static Knapsack knapsack;

	// game loop in main method
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		
		//********************//
		
		knapsack = new KnapsackImpl();
		
		BisonJerky bJ = new BisonJerky(30);
		Coffee c = new Coffee(20);
		
		knapsack.add(bJ);
		knapsack.add(c);
		
		squad = new SquadImpl(1, knapsack);
		
		//*******************//
		
		
		

		//get difficulty by input
		System.out
				.println("Welcome to Sillicon Valley Trail! Choose a Difficulty: \n 1. EASY \n 2. MEDIUM \n 3. HARD");

		int dif = s.nextInt();
		if (dif < 1 || dif > 3) {
			throw new IllegalArgumentException("Not an option");
		}
		switch (dif) {
		case 1:
			adventure = new Adventure(Difficulty.EASY, squad);
																
			break;
		case 2:
			adventure = new Adventure(Difficulty.MEDIUM, squad);
																
			break;
		case 3:
			adventure = new Adventure(Difficulty.HARD, squad);
																
			break;
		}
		System.out.println("You selected "+adventure.getDifficulty().toString());

		//stay in loop to select city and travel to it
		while (true) {
			System.out.println("You are in " + adventure.getCurrentCity().getName()
					+ ". Which city would you like to travel to?\n");
			for(int i = 0; i < adventure.getCities().length; i++){
				System.out.println((i+1)+". "+adventure.getCities()[i].getName());
			}
			int trav = s.nextInt();
			if(trav == 0){ return;}
			adventure.travel(adventure.getCities()[trav-1]);
			
			
			/* if current city is last on list (destination) end programm
			if(adventure.getCurrentCity() == adventure.getCities()[adventure.getCities().length-1]){
				return;
			}
			*/
		}
	}
}
