package a6;

import java.util.Iterator;

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

	public void add(Food item) {
		if (item instanceof PowerUp) {
			powerup_pouch.add((PowerUp) item);
		} else {
			food_pouch.add(item);
		}
	}

	public void add(PowerUp item) {
		powerup_pouch.add(item);
	}

	public void add(Clothing item) {
		clothing_pouch.add(item);
	}

	public void add(Supplies item) {
		if (item instanceof Clothing) {
			add((Clothing) item);
		} else if (item instanceof Food) {
			add((Food) item);
		}
	}

	public int getTotalWeight() {
		return (food_pouch.getTotalWeight() +
				powerup_pouch.getTotalWeight() +
				clothing_pouch.getTotalWeight());
	}

	public Supplies[] getSupplies() {
		Supplies[] food_pouch_items = food_pouch.getItems();
		Supplies[] powerup_pouch_items = powerup_pouch.getItems();
		Supplies[] clothing_pouch_items = clothing_pouch.getItems();

		Supplies[] supplies = new Supplies[food_pouch_items.length + powerup_pouch_items.length + clothing_pouch_items.length];
		int i=0;
		for (int j=0; j<food_pouch_items.length; j++) {
			supplies[i] = food_pouch_items[j];
			i++;
		}
		for (int j=0; j<powerup_pouch_items.length; j++) {
			supplies[i] = powerup_pouch_items[j];
			i++;
		}
		for (int j=0; j<clothing_pouch_items.length; j++) {
			supplies[i] = clothing_pouch_items[j];
			i++;
		}
		return supplies;
	}

	public Food[] getEdibleSupplies() {
		Supplies[] food_pouch_items = food_pouch.getItems();
		Supplies[] powerup_pouch_items = powerup_pouch.getItems();

		Food[] edible_supplies = new Food[food_pouch_items.length + powerup_pouch_items.length];
		int i=0;
		for (int j=0; j<food_pouch_items.length; j++) {
			edible_supplies[i] = (Food) food_pouch_items[j];
			i++;
		}
		for (int j=0; j<powerup_pouch_items.length; j++) {
			edible_supplies[i] = (Food) powerup_pouch_items[j];
			i++;
		}
		return edible_supplies;
	}
	
    public Iterator<Supplies> nameIterator() {
        return new KnapsackNameIterator(food_pouch.nameIterator(), powerup_pouch.nameIterator(), clothing_pouch.nameIterator());
    }

    public Iterator<Supplies> amountIterator() {
        return new KnapsackAmountIterator(food_pouch.amountIterator(), powerup_pouch.amountIterator(), clothing_pouch.amountIterator());
    }

    public Iterator<Supplies> weightIterator() {
        return new KnapsackWeightIterator(food_pouch.weightIterator(), powerup_pouch.weightIterator(), clothing_pouch.weightIterator());
    }	

}
