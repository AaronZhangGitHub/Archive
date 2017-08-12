package a3novice;

public class TShirt extends ClothingImpl {
	static final int weight = 1;
	static final int price = 20;
	static final int warmth = 1;
	static final String name = "t-shirt";
	public TShirt(int amount) {
		super(amount, weight, price, warmth, name);
	}
	
}
