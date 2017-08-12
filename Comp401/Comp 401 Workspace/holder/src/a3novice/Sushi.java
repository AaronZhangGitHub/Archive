package a3novice;

public class Sushi extends FoodImpl{
	static final int weight = 3;
	static final int price = 15;
	static final int fill = 15;
	static final int expiration = 2;
	static final String name = "sushi";
	public Sushi(int amount){
		super(amount, weight, price, fill, expiration, name);
	}
}
