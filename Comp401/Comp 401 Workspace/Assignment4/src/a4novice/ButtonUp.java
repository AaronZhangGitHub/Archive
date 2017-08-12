package a4novice;

public class ButtonUp extends ClothingImpl {
	static final int WEIGHT = 5;
	static final int PRICE = 50;
	static final int WARMTH = 2;
	static final String NAME = "button-up";
	public ButtonUp(int amount) {
		super(amount, WEIGHT, PRICE, WARMTH, NAME);
	}
	
}