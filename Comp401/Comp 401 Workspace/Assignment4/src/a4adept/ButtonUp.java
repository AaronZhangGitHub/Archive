package a4adept;

public class ButtonUp extends ClothingImpl {
	static final int WEIGHT = 5;
	static final int PRICE = 50;
	static final Warmth WARMTH = Clothing.Warmth.MEDIUM;
	static final String NAME = "button-up";
	public ButtonUp(int amount) {
		super(amount, WEIGHT, PRICE, WARMTH, NAME);
	}
	
}