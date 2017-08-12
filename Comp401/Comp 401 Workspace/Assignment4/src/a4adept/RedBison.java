package a4adept;

public class RedBison extends PowerUpImpl{
	static final int WEIGHT = 2;
	static final int PRICE = 7;
	static final int FILL = -10;
	static final int EXPIRATION = 100;
	static final int DURATION = 5;
	static final String NAME = "Red Bison";
	public RedBison(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, DURATION, NAME);
	}
}
