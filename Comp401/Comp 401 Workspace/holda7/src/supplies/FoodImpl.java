package supplies;

public abstract class FoodImpl extends SuppliesImpl implements Food {

	protected int days;
	protected int fill;

	public FoodImpl(int amount, int weight, int price, int fill, int days, String name){
		super(amount, weight, price, name);
		this.fill = fill;
		this.days = days;
	}

	public void consume() throws NoFoodException {
		if (amount > 0) {
			amount--;
		} else {
			throw new NoFoodException();
		}

	}

	public int getDaysTillExpiration() {
		return days;
	}

	public void age() throws FoodExpiredException {
		if(days == 0){
			throw new FoodExpiredException();
		}
		if(days > 0){
			days--;
		}
	}

	public int getFill() {
		return fill;
	}

}
