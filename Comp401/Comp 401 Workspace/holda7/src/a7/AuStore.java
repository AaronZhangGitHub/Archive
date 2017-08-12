package a7;

public class AuStore implements Store {
	
	private StoreImpl s;
	
	public AuStore(StoreImpl s){
		this.s = s;
		s.getPrices().remove("fleece");
	}

	@Override
	public void enter(Squad squad) {
		s.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return s.getPrice(item_name);
	}

	@Override
	public String[] getItemNames() {
		return s.getItemNames();
	}

}
