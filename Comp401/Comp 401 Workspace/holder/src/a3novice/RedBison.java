package a3novice;

public class RedBison extends PowerUpImpl{
	static final int weight = 2;
	static final int price = 7;
	static final int fill = -10;
	static final int expiration = 100;
	static final int duration = 5;
	static final String name = "Red Bison";
	public RedBison(int amount){
		super(amount, weight, price, fill, expiration, duration, name);
	}
}
