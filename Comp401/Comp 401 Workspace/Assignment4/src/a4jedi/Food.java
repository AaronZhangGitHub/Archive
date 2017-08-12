package a4jedi;

public interface Food extends Supplies{

	void consume() throws NoFoodException;  //consume a food, throws NoFoodException if there is no food
	
	int getDaysTillExpiration(); //returns the amount of days until the food expires
	void age() throws FoodExpiredException; //ages the food, if it is expire throws FoodExpiredException
	
	int getFill(); //returns the fill of the food
}