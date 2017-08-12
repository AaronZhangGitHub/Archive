package a7;

public class PAStore implements Store {
	
	private StoreImpl store;
	
	public PAStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("t-shirt") ||item_name.equals("fleece") ){
			return ((store.getPrice(item_name) + 1.50) * 1.05);
		}
		return ((store.getPrice(item_name) + 1.50));
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}
