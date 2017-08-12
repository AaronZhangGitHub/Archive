package a5novice;

import supplies.Clothing;
import supplies.Food;
import supplies.PowerUp;
import supplies.Supplies;

public class KnapsackImpl implements Knapsack{
	private FoodPouch food;
	private ClothingPouch clothing;
	private PowerUpPouch powerup;
	
	public KnapsackImpl(){	
		food = new FoodPouch();
		clothing = new ClothingPouch();
		powerup = new PowerUpPouch();
	}

	public void add(Food item) {
		if(item instanceof PowerUp){
			powerup.add(item);
		}
		else{
			food.add(item);
		}
	}

	public void add(PowerUp item) {
		powerup.add(item);
		
	}

	public void add(Clothing item) {
		clothing.add(item);
		
	}

	public void add(Supplies item) {
		if(item instanceof PowerUp){
			powerup.add(item);
		}
		else if (item instanceof Food){
			food.add(item);
		}
		else{
			clothing.add(item);
		}
		
	}

	public int getTotalWeight() {
		return food.getTotalWeight()+clothing.getTotalWeight()+powerup.getTotalWeight();
	}

	public Supplies[] getSupplies() {
		Supplies[] foodArray = food.getItems();
		Supplies[] clothingArray = clothing.getItems();
		Supplies[] powerupArray = powerup.getItems();
		int size = powerupArray.length+clothingArray.length+foodArray.length;
		Supplies[] suppliesArray = new Supplies[size];
		int array_point_count = 0;//counts where the array is at so you can continue to concatenate without confusion
		for(int i = 0;i<foodArray.length;i++){
			suppliesArray[array_point_count] = foodArray[i];
			array_point_count++;
		}
		for(int i = 0;i<clothingArray.length;i++){
			suppliesArray[array_point_count] = clothingArray[i];
			array_point_count++;
		}
		for(int i = 0;i<powerupArray.length;i++){
			suppliesArray[array_point_count] = powerupArray[i];
			array_point_count++;
		}
		return suppliesArray;
	}

	public Food[] getEdibleSupplies() {
		Supplies[] foodArray = food.getItems();
		Supplies[] powerupArray = powerup.getItems();
		int size = powerupArray.length+foodArray.length;
		Food[] edibleArray = new Food[size];
		int array_point_count = 0;//counts where the array is at so you can continue to concatenate without confusion
		for(int i = 0;i<foodArray.length;i++){
			 edibleArray[array_point_count] = (Food)foodArray[i];
			array_point_count++;
		}
		for(int i = 0;i<powerupArray.length;i++){
			edibleArray[array_point_count] = (Food)powerupArray[i];
			array_point_count++;
		}
		return edibleArray;
	}
	
}
