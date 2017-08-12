package a7;

import java.util.List;

import supplies.Supplies;

public class StoreImpl implements Store {
	private List<Supplies> items;

	public static Store makeStore(City c) {
		Store store = new StoreImpl();
		if (c.getName().equals("Seattle")) {
			return new CoffeeStore(store, 1.04, 1, 1.50);
		}
		if (c.getName().equals("Charlotte")) {
			return new NoFleeceStore(store, 1, 1.04, 0); 
		}
		if (c.getName().equals("Chapel Hill")) {
			return new TaxedStore(store, 1, 1.04,0);
		}
		if (c.getName().equals("Atlanta")) {
			return new NoFleeceStore(store, 1.03, 1.03, 0);
		}
		if (c.getName().equals("New York")) {
			return new TaxedStore(store, 1.05, 1.05, 1.50);
		}
		if (c.getName().equals("Chicago")) {
			return new TaxedStore(store, 1.05, 1, 0);
		}
		if (c.getName().equals("San Francisco")) {
			return new TaxedStore(store,1.08, 1.05, 1.50);
		}
		if (c.getName().equals("Palo Alto")) {
			return new TaxedStore(store, 1, 1.05, 1.50);
		}
		if (c.getName().equals("Washington D.C.")) {
			return new TaxedStore(store, 1.05, 1, 1.5);
		}
		if (c.getName().equals("Minneapolis")) {
			return new TaxedStore(store, 1, 1, 0);
		}
		if (c.getName().equals("Austin")) {
			return new NoFleeceStore(store, 1, 1, 0);
		} else {
			return null;
		}	
	}

	@Override
	public void enter(Squad squad) {

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		String[] allItems = this.getItemNames();
		String[] names = { "bison jerky", "burrito", "button-up", "coffee",
				"fleece", "ramen noodles", "Red Bison", "sushi", "t-shirt" };
		double[] prices = { 2.00, 4.00, 10.00, 2.50, 12.00, 0.50, 3.25, 3.75,
				5.00 };
		for (int i = 0; i < allItems.length; i++) {
			if (allItems[i].equals(item_name)) {
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals(item_name))
						
					{
						return prices[j];
					}
				}
			}
		}

		throw new ItemNotForSaleException();
	}

	public String[] getItemNames() {
		Supplies[] allItems = (Supplies[]) items.toArray();
		String[] names = new String[items.size()];
		for (int i = 0; i < items.size(); i++) {
			names[i] = allItems[i].getName();
		}
		return names;
	}

}
