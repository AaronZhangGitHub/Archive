package a4novice;


public class TShirt extends ClothingImpl {
	static final int WEIGHT = 1;
	static final int PRICE = 20;
	static final int WARMTH = 1;
	static final String NAME = "t-shirt";
	public TShirt(int amount) {
		super(amount, WEIGHT, PRICE, WARMTH, NAME);
	}
	
}
