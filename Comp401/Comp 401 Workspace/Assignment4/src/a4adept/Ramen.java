package a4adept;

public class Ramen extends FoodImpl{
	static final int WEIGHT = 1;
	static final int PRICE = 1;
	static final int FILL = 1;
	static final int EXPIRATION = 1000;
	static final String NAME = "ramen noodles";
	public Ramen(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, NAME);
	}
}
