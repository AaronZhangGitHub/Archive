package supplies;

public class Burrito extends FoodImpl{
	static final int WEIGHT= 5;
	static final int PRICE = 7;
	static final int FILL = 10;
	static final int EXPIRATION = 5;
	static final String NAME = "burrito";
	public Burrito(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, NAME);
	}
}