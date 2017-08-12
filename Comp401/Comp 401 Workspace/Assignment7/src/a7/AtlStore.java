package a7;

public class AtlStore implements Store {
	
	private StoreImpl store;
	
	public AtlStore(StoreImpl s){
		this.store = s;
		s.getPrices().remove("fleece");
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("fleece") || item_name.equals("t-shirt")){
			return (store.getPrice(item_name) * 1.06);
		}
		return (store.getPrice(item_name) * 1.03);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}
