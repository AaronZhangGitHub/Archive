package supplies;

public class Fleece extends ClothingImpl {
	static final int WEIGHT = 10;
	static final int PRICE = 100;
	static final Warmth WARMTH = Clothing.Warmth.WARM;
	static final String NAME = "fleece";
	public Fleece(int amount) {
		super(amount, WEIGHT, PRICE, WARMTH, NAME);
	}
	
}
