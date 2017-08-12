package person;

import supplies.Food;
import supplies.NoFoodException;

public interface Person {
	
	// create enum for status
	public enum Status {
		HEALTHY, NOROVIRUS, DYSNTERY
	}

	int getCurrentHP();
	int getMaxHP();
	int getSkill();
	
	void eat(Food food) throws NoFoodException;
	Person.Status getStatus();
	void setStatus(Person.Status new_status);
	String getName();
	
	void special();
		
}