package a7;

import supplies.Clothing;
import supplies.ClothingImpl;
import supplies.Food;
import supplies.FoodExpiredException;
import supplies.FoodImpl;
import supplies.PowerUp;
import supplies.PowerUpImpl;
import supplies.Supplies;

public class KnapsackImpl implements Knapsack {

	// declare pouches, instantiate in constructor
	private PouchImpl<Food> foodPouch;
	private PouchImpl<Clothing> clothingPouch;
	private PouchImpl<PowerUp> powerUpPouch;

	// constructor
	public KnapsackImpl() {
		foodPouch = new PouchImpl<Food>();
		clothingPouch = new PouchImpl<Clothing>();
		powerUpPouch = new PouchImpl<PowerUp>();

	}

	// check if food or powerup
	@Override
	public void add(Food item) {
		if (item instanceof PowerUpImpl) {
			powerUpPouch.add((PowerUp) item);
		} else if (item instanceof FoodImpl) {
			foodPouch.add(item);
		} else {
			throw new IllegalArgumentException();
		}
	}

	// add PowerUp
	@Override
	public void add(PowerUp item) {
		if (item == null) {
			throw new IllegalArgumentException();
		} else {
			powerUpPouch.add(item);
		}
	}

	// add Clothing
	@Override
	public void add(Clothing item) {
		if (item == null) {
			throw new IllegalArgumentException();
		} else {
			clothingPouch.add(item);
		}

	}

	// add any supply, check which type it is
	@Override
	public void add(Supplies item) {
		if (item instanceof PowerUp) {
			powerUpPouch.add((PowerUp) item);
		} else if (item instanceof FoodImpl) {
			foodPouch.add((Food) item);
		} else if (item instanceof ClothingImpl) {
			clothingPouch.add((Clothing) item);
		} else {
			throw new IllegalArgumentException();
		}

	}

	// remove methods

	public void remove(Food item) {
		foodPouch.remove(item);
	}

	public void remove(PowerUp item) {
		powerUpPouch.remove(item);
	}

	public void remove(Clothing item) {
		clothingPouch.remove(item);
	}

	public void remove(Supplies item) {
		if (item instanceof PowerUp) {
			powerUpPouch.remove((PowerUp) item);
		} else if (item instanceof Food) {
			foodPouch.remove((Food) item);
		} else if (item instanceof Clothing) {
			clothingPouch.remove((Clothing) item);
		} else {
			throw new IllegalArgumentException();
		}
	}

	// get total weight of each pouch, add up
	@Override
	public int getTotalWeight() {
		return foodPouch.getTotalWeight() + powerUpPouch.getTotalWeight()
				+ clothingPouch.getTotalWeight();
	}

	// use three for loops, one per pouch, add to one big array
	@Override
	public Supplies[] getSupplies() {
		Supplies[] array = new Supplies[(foodPouch.getItems().length
				+ powerUpPouch.getItems().length + clothingPouch.getItems().length)];
		for (int j = 0; j < foodPouch.getItems().length; j++) {
			array[j] = foodPouch.getItems()[j];
		}
		for (int i = 0; i < powerUpPouch.getItems().length; i++) {
			array[i + foodPouch.getItems().length] = powerUpPouch.getItems()[i];
		}
		for (int k = 0; k < clothingPouch.getItems().length; k++) {
			array[k + foodPouch.getItems().length
					+ powerUpPouch.getItems().length] = clothingPouch
					.getItems()[k];
		}
		return array;

	}

	// use two for loops, one per food pouch, add to one big array
	// cast to food
	@Override
	public Food[] getEdibleSupplies() {
		Food[] array = new Food[(foodPouch.getItems().length + powerUpPouch
				.getItems().length)];
		for (int j = 0; j < foodPouch.getItems().length; j++) {
			array[j] = (Food) foodPouch.getItems()[j];
		}
		for (int i = 0; i < powerUpPouch.getItems().length; i++) {
			array[i + foodPouch.getItems().length] = (Food) powerUpPouch
					.getItems()[i];
		}
		return array;
	}

	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {
		for (int i = 0; i < getEdibleSupplies().length; i++) {
			if (getEdibleSupplies()[i].getDaysTillExpiration() == 0) {
				remove(getEdibleSupplies()[i]);
			}
			try {
				getEdibleSupplies()[i].age();
			} catch (FoodExpiredException e) {
			// do nothing
			}


		}

	}

}
