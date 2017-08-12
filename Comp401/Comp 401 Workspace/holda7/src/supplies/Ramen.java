package supplies;

public class Ramen extends FoodImpl {

	public Ramen(int amount) {
		super(amount, 1, 1, 1, 1000, "ramen noodles");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}
}
