package a4novice;

public class Coffee extends PowerUpImpl{
	static final int WEIGHT = 1;
	static final int PRICE = 5;
	static final int FILL = 0;
	static final int EXPIRATION = 100;
	static final int DURATION = 1;
	static final String NAME = "coffee";
	public Coffee(int amount){
		super(amount, WEIGHT, PRICE, FILL, EXPIRATION, DURATION, NAME);
	}
}
