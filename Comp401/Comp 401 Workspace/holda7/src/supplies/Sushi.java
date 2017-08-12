package supplies;

public class Sushi extends FoodImpl {

	public Sushi(int amount) {
		super(amount, 3, 15, 15, 2, "sushi");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
