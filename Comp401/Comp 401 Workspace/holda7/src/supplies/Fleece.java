package supplies;

public class Fleece extends ClothingImpl {

	public Fleece(int amount) {
		super(amount, 10, 100, Warmth.WARM, "fleece");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
