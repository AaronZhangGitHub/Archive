package person;

import java.util.Random;

import supplies.Food;
import supplies.NoFoodException;

public abstract class PersonImpl implements Person {

	// declare protected variables for subclasses
	protected Status status;
	protected int currentHP;
	protected int maxHP;
	protected int skill;
	protected String name;
	
	// constructor to assign name, skill, etc
	public PersonImpl(String name, int maxHP, int skill, Status status){
		if(name == null){
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.skill = skill;
		this.maxHP = maxHP;
		currentHP = maxHP;
		this.status = status;
		
	}
	
	// getters
	@Override
	public int getCurrentHP() {
		return currentHP;
	}

	@Override
	public int getMaxHP() {
		return maxHP;
	}

	@Override
	public int getSkill() {
		return skill;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public String getName() {
		return name;
	}
	
	// setter
	@Override
	public void setStatus(Status new_status) {
		status = new_status;
	}

	// eat foods
	public void eat(Food food) throws NoFoodException{
		if(food == null){
			throw new IllegalArgumentException("Your food is null");
		}
		food.consume();
		currentHP += food.getFill();
		if(currentHP <0){currentHP = 0;}
		if(currentHP > maxHP){currentHP = maxHP;}
		
	}

}
