package supplies;

public class BisonJerky extends FoodImpl {

	public BisonJerky(int amount) {
		super(amount, 5, 10, 6, 40, "bison jerky");
		if(amount < 0){
			throw new IllegalArgumentException("Negative amounts aren't alowed");
		}
	}

}
