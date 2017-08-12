package a7;

public class SeaStore implements Store {
	
	private StoreImpl s;
	
	public SeaStore(StoreImpl s){
		this.s = s;
		s.getPrices().remove("bison jerky");
		s.getPrices().remove("burrito");
		s.getPrices().remove("button-up");
		s.getPrices().remove("fleece");
		s.getPrices().remove("ramen noodles");
		s.getPrices().remove("Red Bison");
		s.getPrices().remove("sushi");
		s.getPrices().remove("t-shirt");
	}

	@Override
	public void enter(Squad squad) {
		s.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return ((s.getPrice(item_name) + 1.50) * 1.04);
	}

	@Override
	public String[] getItemNames() {
		return s.getItemNames();
	}

}
