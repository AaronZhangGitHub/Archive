package supplies;

public class ButtonUp extends ClothingImpl {

	public ButtonUp(int amount) {
		super(amount, 5, 50, Warmth.MEDIUM, "button-up");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
