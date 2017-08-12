package supplies;

public class Burrito extends FoodImpl {

	public Burrito(int amount) {
		super(amount, 5, 7, 10, 5, "burrito");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
