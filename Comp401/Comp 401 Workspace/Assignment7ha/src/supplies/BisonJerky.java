package supplies;

public class BisonJerky extends FoodImpl {
	
	/* Named Constants */
	static final int JERKY_WEIGHT = 5;
	static final int JERKY_PRICE = 10;
	static final int JERKY_FILL = 6;
	static final int JERKY_EXPR = 40;
	static final String JERKY_NAME = "bison jerky";
	
	public BisonJerky(int amount) {
		super(amount, JERKY_WEIGHT, JERKY_PRICE, JERKY_NAME, JERKY_EXPR, JERKY_FILL);
	}
}