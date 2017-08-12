package supplies;

public class Burrito extends FoodImpl {
	
	/* Named Constants */
	static final int BURRITO_WEIGHT = 5;
	static final int BURRITO_PRICE = 7;
	static final int BURRITO_FILL = 10;
	static final int BURRITO_EXPR = 5;
	static final String BURRITO_NAME = "burrito";
	
	public Burrito(int amount) {
		super(amount, BURRITO_WEIGHT, BURRITO_PRICE, BURRITO_NAME, BURRITO_EXPR, BURRITO_FILL);
	}
}