package a7;

public class SeaStore implements Store {
	
	private StoreImpl store;
	
	public SeaStore(StoreImpl s){
		this.store = s;
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
		store.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return ((store.getPrice(item_name) + 1.50) * 1.04);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}
