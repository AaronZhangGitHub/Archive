package supplies;

public class TShirt extends ClothingImpl {

	public TShirt(int amount) {
		super(amount, 1, 20, Warmth.LIGHT, "t-shirt");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
