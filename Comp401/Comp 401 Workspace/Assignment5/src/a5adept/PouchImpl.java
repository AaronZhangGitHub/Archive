package a5adept;

import java.util.List;

import supplies.Supplies;


public class PouchImpl implements Pouch{

	protected List<Supplies> items;
	
	public PouchImpl(){		
	}
	public void add(Supplies item) {
		throw new IllegalArgumentException("should get overrided and not reach here");
	}

	public int getTotalWeight() {
		int total = 0;
		for(int i = 0;i<items.size();i++){
			total +=items.get(i).getTotalWeight();
		}
		return total;
	}

	public Supplies[] getItems() {
		Supplies[] hold = new Supplies[items.size()];
		for(int i = 0;i<items.size();i++){
			hold[i]=items.get(i);
		}
		return hold;
	}
	public int getSize(){
		return items.size();
	}
}
