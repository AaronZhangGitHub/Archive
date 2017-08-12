package a7;

public class MinnStore implements Store {
	
	private StoreImpl s;
	
	public MinnStore(StoreImpl s){
		this.s = s;
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
