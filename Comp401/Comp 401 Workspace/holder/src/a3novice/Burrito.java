package a3novice;

public class Burrito extends FoodImpl{
	static final int weight = 5;
	static final int price = 7;
	static final int fill = 10;
	static final int expiration = 5;
	static final String name = "burrito";
	public Burrito(int amount){
		super(amount, weight, price, fill, expiration, name);
	}
}