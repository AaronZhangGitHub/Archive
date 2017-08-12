package a3novice;

public class Ramen extends FoodImpl{
	static final int weight = 1;
	static final int price = 1;
	static final int fill = 1;
	static final int expiration = 1000;
	static final String name = "ramen noodles";
	public Ramen(int amount){
		super(amount, weight, price, fill, expiration, name);
	}
}
