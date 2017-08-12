package supplies;

abstract public class FoodImpl extends SuppliesImpl implements Food{
	private int fill;
	private int expiration;
	public FoodImpl(int amount, int weight, int price, int fill, int expiration, String name) {
		super(amount, weight, price, name);
		this.fill = fill;
		this.expiration = expiration;
	}

	public void consume() throws NoFoodException {
		if(amount<=0){
			throw new NoFoodException();
		}
		amount--;
		
	}
	public int getDaysTillExpiration() {
		return expiration;
	}

	public void age() throws FoodExpiredException {
		expiration--;
		if(expiration<=0){
			throw new FoodExpiredException();
		}
		
	}

	public int getFill() {
		return fill;
	}
	
}
