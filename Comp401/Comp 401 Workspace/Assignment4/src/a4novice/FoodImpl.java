package a4novice;

public class FoodImpl extends SuppliesImpl implements Food{
	private int fill; //fill of the food item
	private int expiration; //expiration time 
	protected FoodImpl(int amount, int weight, int price, int fill, int expiration, String name) {
		super(amount, weight, price, name);
		this.fill = fill;
		this.expiration = expiration;
	}

	public void consume() throws NoFoodException {
		if(amount<=0){
			//Checks if there is food to consume
			throw new NoFoodException();
		}
		//If there is food to consume subtracts the amount of food you have
		amount--;
		
	}
	public int getDaysTillExpiration() {
		//returns how many days until the food expires
		return expiration;
	}

	public void age() throws FoodExpiredException {
		expiration--; //ages the food, less days until expiration
		if(expiration<=0){
			//if food is expired, throws Exception
			throw new FoodExpiredException();
		}
		
	}

	public int getFill() {
		//returns how filling the food is
		return fill;
	}
	
}
