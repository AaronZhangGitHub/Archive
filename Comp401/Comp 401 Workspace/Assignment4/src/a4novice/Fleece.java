package a4novice;

public class Fleece extends ClothingImpl {
	static final int WEIGHT = 10;
	static final int PRICE = 100;
	static final int WARMTH = 3;
	static final String NAME = "fleece";
	public Fleece(int amount) {
		super(amount, WEIGHT, PRICE, WARMTH, NAME);
	}
	
}
