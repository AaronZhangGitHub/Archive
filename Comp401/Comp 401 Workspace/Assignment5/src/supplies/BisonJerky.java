package supplies;

public class BisonJerky extends FoodImpl{
	static final int WEIGHT = 5;
	static final int PRICE = 10;
	static final int FILL = 6;
	static final int EXPIRATION = 40;
	static final String NAME = "bison jerky";
	public BisonJerky(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, NAME);
	}
}
