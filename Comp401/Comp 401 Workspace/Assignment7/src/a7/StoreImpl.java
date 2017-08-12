package a7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import supplies.*;
public class StoreImpl implements Store{
	private Squad squad;
	private static Map<String,Double> price_rel;

	public StoreImpl(){
		price_rel = new HashMap<String, Double>();
		price_rel.put("burrito", 4.0);
		price_rel.put("ramen noodles", 0.5);
		price_rel.put("Red Bison", 3.25);
		price_rel.put("button-up", 10.0);
		price_rel.put("coffee", 2.5);
		price_rel.put("t-shirt", 5.0);
		price_rel.put("fleece", 12.0);
		price_rel.put("sushi", 3.75);
		price_rel.put("bison jerky", 2.0);
	}
	
	public static Store makeStore(City city) {

		Store store = null;

		switch (city.getName()) {
		case "Chapel Hill":
			store = new CHStore(new StoreImpl());
			break;
		case "Charlotte":
			store = new CharlloteStore(new StoreImpl());
			break;
		case "Atlanta":
			store = new AtlStore(new StoreImpl());
			break;
		case "Washington D.C.":
			store = new WDCStore(new StoreImpl());
			break;
		case "New York":
			store = new NYStore(new StoreImpl());
			break;
		case "Chicago":
			store = new ChiStore(new StoreImpl());
			break;
		case "Austin":
			store = new AustinStore(new StoreImpl());
			break;
		case "Minneapolis":
			store = new MinnStore(new StoreImpl());
			break;
		case "Seattle":
			store = new SeaStore(new StoreImpl());
			break;
		case "San Francisco":
			store = new SFStore(new StoreImpl());
			break;
		case "Palo Alto":
			store = new PAStore(new StoreImpl());
			break;
		}

		return store;
	}
	
	public void enter(Squad squad) {
		this.squad = squad;
	}
	
	public Map<String,Double> getPrices(){
		return price_rel;
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if (item_name == null) {
			throw new ItemNotForSaleException();
		} else if (price_rel.containsKey(item_name)) {
			return price_rel.get(item_name);
		} else {
			throw new ItemNotForSaleException();
		}
	}

	@Override
	public String[] getItemNames() {
		Set<String> items = price_rel.keySet();
		return items.toArray(new String[items.size()]);
	}
	

}
