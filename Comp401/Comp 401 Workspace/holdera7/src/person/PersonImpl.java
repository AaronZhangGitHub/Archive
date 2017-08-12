package person;

import supplies.Food;
import supplies.NoFoodException;

public abstract class PersonImpl implements Person {
	
	/* Instance variables */
	private Person.Status status;
	protected int current_hp;  // Between 0 and maxHP
	private int max_hp;
	protected int skill;       // The person's Java Skill
	private String name;
	
	/* Constructors */
	
	// Initializes max_hp and skill to a random value in the given range
	protected PersonImpl(String name, int hp_range_min, int hp_range_max, 
	                     int skill_range_min, int skill_range_max) {										 
		if (name == null
				|| hp_range_min < 0
				|| hp_range_max < 0
				|| skill_range_min < 0
				|| skill_range_max < 0
				|| hp_range_max < hp_range_min  
				|| skill_range_max < skill_range_min)
			throw new IllegalArgumentException();
			
		this.name = name;
		this.max_hp = randomInt(hp_range_min, hp_range_max);
		this.skill  = randomInt(skill_range_min, skill_range_max);
	}
	
	
	/* Person interface methods */
	public int getCurrentHP() {
		return current_hp;
	}
	
	public int getMaxHP() {
		return max_hp;
	}
	
	public int getSkill() {
		return skill;
	}
	
	public void eat(Food food) throws NoFoodException {
		if (food == null) throw new IllegalArgumentException("Null argument");

		food.consume();	 // may throw NoFoodException
		current_hp += food.getFill();
		if (current_hp > getMaxHP()) {
			current_hp = getMaxHP();
		}
	}
	
	public Person.Status getStatus() {
		return status;
	}
	public void setStatus(Person.Status new_status) {
		status = new_status;
	}
	public String getName() {
		return name;
	}
	
	// Helper method for generating a random int in [a, b]
	private int randomInt(int a, int b) {
		if (b > a) return -1;
		
		double x = Math.random();
		// Map [0, 1) to [a, b+1) linearly and round down
		int diff = Math.abs(b-a);
		return (int) Math.floor(diff*x + a);
	}
}