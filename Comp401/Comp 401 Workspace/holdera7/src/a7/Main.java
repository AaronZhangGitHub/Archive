package a7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Select hardness: ");
		int hardness = s.nextInt();
		Adventure.Difficulty difficulty;
		if (hardness == 1) {
			difficulty = Adventure.Difficulty.EASY;
		} else if (hardness == 2) {
			difficulty = Adventure.Difficulty.MEDIUM;			
		} else {
			difficulty = Adventure.Difficulty.HARD;						
		}
		
		Adventure adventure = new Adventure(difficulty, null);
		
		City[] cities = adventure.getCities();
		
		while(true) {
			System.out.println("You are in " + adventure.getCurrentCity().getName() + ". Which city would you like to travel to?");
			for (int i=0; i<cities.length; i++) {
				System.out.println((i+1) + ") " + cities[i].getName());
			}
			int city_num = s.nextInt();
			if (city_num == 0) {
				break;
			}
			adventure.travel(cities[city_num-1]);
		}
	}
}
