package a7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreImpl implements Store {

	private Map<String, Double> prices;

	private StoreImpl() {
		prices = new HashMap<String, Double>();
		
		prices.put("bison jerky", 2.0);
		prices.put("burrito", 4.0);
		prices.put("button-up", 10.0);
		prices.put("coffee", 2.5);
		prices.put("fleece", 12.0);
		prices.put("ramen noodles", 0.5);
		prices.put("Red Bison", 3.25);
		prices.put("sushi", 3.75);
		prices.put("t-shirt", 5.0);

	}

	public static Store makeStore(City c) {

		Store s = null;

		switch (c.getName()) {
		case "Chapel Hill":
			s = new CHStore(new StoreImpl());
			break;
		case "Charlotte":
			s = new ChaStore(new StoreImpl());
			break;
		case "Atlanta":
			s = new AtlStore(new StoreImpl());
			break;
		case "Washington, D.C.":
			s = new WDCStore(new StoreImpl());
			break;
		case "New York":
			s = new NYStore(new StoreImpl());
			break;
		case "Chicago":
			s = new ChiStore(new StoreImpl());
			break;
		case "Austin":
			s = new AuStore(new StoreImpl());
			break;
		case "Minneapolis":
			s = new MinnStore(new StoreImpl());
			break;
		case "Seattle":
			s = new SeaStore(new StoreImpl());
			break;
		case "San Francisco":
			s = new SFStore(new StoreImpl());
			break;
		case "Palo Alto":
			s = new PAStore(new StoreImpl());
			break;
		}

		return s;
	}

	@Override
	public void enter(Squad squad) {
		//
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if (item_name == null) {
			throw new ItemNotForSaleException();
		} else if (prices.containsKey(item_name)) {
			return prices.get(item_name);
		} else {
			throw new ItemNotForSaleException();
		}
	}

	@Override
	public String[] getItemNames() {
		
		Set<String> keys = prices.keySet();
		String[] s = keys.toArray(new String[keys.size()]);
		return s;
	}
	
	public Map<String, Double> getPrices(){
		return prices;
	}
}
