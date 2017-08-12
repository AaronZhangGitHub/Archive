package supplies;

public abstract class PowerUpImpl extends FoodImpl implements PowerUp {

	protected int duration;
	
	public PowerUpImpl(int amount, int weight, int price, int fill, int days, String name, int duration){
		super(amount, weight, price, fill, days, name);
		this.duration = duration;
	}
	public int getDuration() {
		return duration;
	}

}
