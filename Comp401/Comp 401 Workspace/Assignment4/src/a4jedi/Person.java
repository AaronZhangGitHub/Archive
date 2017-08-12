package a4jedi;

public interface Person {
	int getCurrentHP(); //returns current HP of the person
	int getMaxHP();//returns the persons max HP
	int getSkill();//returns the persons skill level
	
	void eat(Food food) throws NoFoodException; //person eats and adds/subtracts to their health... decreases amount of food
	Person.Status getStatus();//returns the persons Health status
	void setStatus(Person.Status new_status); //sets the persons health status
	String getName();//returns the persons name
	
	void special();//enacts the persons special ability
	
	public enum Status {
		//three health statuses 
		HEALTHY,NOROVIRUS,DYSENTERY,
	}
}