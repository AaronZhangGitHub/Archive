package person;

import supplies.Food;
import supplies.NoFoodException;

public class Hacker extends PersonImpl{

	// declare beast mode
	private boolean beast_mode;
	
	// delegate to super constructor to set name, skill, etc
	public Hacker(String name) {
		super(name,  (int)(Math.random()*41 + 60),(int)(Math.random()*41 + 60), Status.HEALTHY);
		beast_mode = false;
	}
	
	// eat method is different
	@Override
	public void eat(Food food) throws NoFoodException{
		if(food == null){
			throw new IllegalArgumentException("Your food is null");
		}
		food.consume();
		currentHP -= food.getFill();
		if(currentHP <0){currentHP = 0;}
		if(currentHP > maxHP){currentHP = maxHP;}
	}
	
	@Override
	public void special(){
		beast_mode = true;
	}

}
