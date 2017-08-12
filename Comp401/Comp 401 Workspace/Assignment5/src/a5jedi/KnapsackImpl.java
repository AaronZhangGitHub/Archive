package a5jedi;

import supplies.Clothing;
import supplies.Food;
import supplies.PowerUp;
import supplies.Supplies;

public class KnapsackImpl implements Knapsack {

	private Pouch<Food> food_pouch;
	private Pouch<PowerUp> powerup_pouch;
	private Pouch<Clothing> clothing_pouch;

	public KnapsackImpl() {
		food_pouch = new PouchImpl<Food>();
		powerup_pouch = new PouchImpl<PowerUp>();
		clothing_pouch = new PouchImpl<Clothing>();

	}

	@Override
	public void add(Food item) {
		//if the item is a food item adds it into the pouch
		if (item instanceof PowerUp) {
			//checks if it is a powerup first, if it is adds it into the powerup pouch
			powerup_pouch.add((PowerUp) item);
		} else {
			//if it is not a powerup it is a food
			food_pouch.add(item);
		}
	}

	@Override
	public void add(PowerUp item) {
		powerup_pouch.add(item);
	}

	@Override
	public void add(Clothing item) {
		clothing_pouch.add(item);
	}

	@Override
	public void add(Supplies item) {
		//depending on item instance, adds the item to the appropriate area
		if (item instanceof Clothing) {
			add((Clothing) item);
		} else if (item instanceof Food) {
			add((Food) item);
		}
	}

	@Override
	public int getTotalWeight() {
		//total weight of each pouch returned
		return (food_pouch.getTotalWeight() +
				powerup_pouch.getTotalWeight() +
				clothing_pouch.getTotalWeight());
	}

	@Override
	public Supplies[] getSupplies() {
		Supplies[] food_pouch_items = food_pouch.getItems();
		Supplies[] powerup_pouch_items = powerup_pouch.getItems();
		Supplies[] clothing_pouch_items = clothing_pouch.getItems();
		
		//total length for all the supplies added up 
		Supplies[] supplies = new Supplies[food_pouch_items.length + powerup_pouch_items.length + clothing_pouch_items.length];
		int i=0;
		for (int j=0; j<food_pouch_items.length; j++) {
			//puts the food pouch items into the supplies array
			supplies[i] = food_pouch_items[j];
			i++;
		}
		for (int j=0; j<powerup_pouch_items.length; j++) {
			//puts the powerup pouch items into the supplies array
			supplies[i] = powerup_pouch_items[j];
			i++;
		}
		for (int j=0; j<clothing_pouch_items.length; j++) {
			//puts the clothing pouch items into the supplies array
			supplies[i] = clothing_pouch_items[j];
			i++;
		}
		return supplies;
	}

	@Override
	public Food[] getEdibleSupplies() {
		//only retunrs the edible supplies (Food and powerups)
		Supplies[] food_pouch_items = food_pouch.getItems();
		Supplies[] powerup_pouch_items = powerup_pouch.getItems();

		Food[] edible_supplies = new Food[food_pouch_items.length + powerup_pouch_items.length]; //total number of edible supplies
		int i=0;
		for (int j=0; j<food_pouch_items.length; j++) {
			//puts the food pouch items into the supplies array
			edible_supplies[i] = (Food) food_pouch_items[j];
			i++;
		}
		for (int j=0; j<powerup_pouch_items.length; j++) {
			//puts the powerup pouch items into the supplies array
			edible_supplies[i] = (Food) powerup_pouch_items[j];
			i++;
		}
		return edible_supplies;
	}	
}
