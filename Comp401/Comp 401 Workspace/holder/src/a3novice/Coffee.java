package a3novice;

public class Coffee extends PowerUpImpl{
	static final int weight = 1;
	static final int price = 5;
	static final int fill = 0;
	static final int expiration = 100;
	static final int duration = 1;
	static final String name = "coffee";
	public Coffee(int amount){
		super(amount, weight, price, fill, expiration, duration, name);
	}
}
