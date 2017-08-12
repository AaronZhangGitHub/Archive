package a3novice;

public class BisonJerky extends FoodImpl{
	static final int weight = 5;
	static final int price = 10;
	static final int fill = 6;
	static final int expiration = 40;
	static final String name = "bison jerkey";
	public BisonJerky(int amount){
		super(amount, weight, price, fill, expiration, name);
	}
}
