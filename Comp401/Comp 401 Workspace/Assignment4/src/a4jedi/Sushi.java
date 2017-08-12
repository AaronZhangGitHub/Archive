package a4jedi;

public class Sushi extends FoodImpl{
	static final int WEIGHT = 3;
	static final int PRICE = 15;
	static final int FILL = 15;
	static final int EXPIRATION = 2;
	static final String NAME = "sushi";
	public Sushi(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, NAME);
	}
}
