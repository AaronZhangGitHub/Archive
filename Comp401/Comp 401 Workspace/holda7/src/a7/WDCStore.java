package a7;

public class WDCStore implements Store {
	
	private StoreImpl s;
	
	public WDCStore(StoreImpl s){
		this.s = s;
	}

	@Override
	public void enter(Squad squad) {
		s.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return ((s.getPrice(item_name) + 1.50) * 1.05);
	}

	@Override
	public String[] getItemNames() {
		return s.getItemNames();
	}

}
