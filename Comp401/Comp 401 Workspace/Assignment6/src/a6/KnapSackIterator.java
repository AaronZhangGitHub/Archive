package a6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import supplies.Supplies;

public class KnapSackIterator implements Iterator<Supplies>{
	private Iterator<Supplies> food;
	private Iterator<Supplies> powerUp;
	private Iterator<Supplies> clothing;
	private Supplies next_food;
	private Supplies next_clothing;
	private Supplies next_powerUp;
	Comparator<Supplies> compare;
	
	public KnapSackIterator(Iterator<Supplies> food,Iterator<Supplies> powerUp,Iterator<Supplies> clothing, Comparator<Supplies> compare){
		this.food = food;
		this.powerUp = powerUp;
		this.clothing = clothing;
		this.compare = compare;
		next_food=null;
		next_clothing=null;
		next_powerUp=null;
	}

	public boolean hasNext() {
		if(food.hasNext()&&next_food==null){
			next_food = food.next();
		}
		if(powerUp.hasNext()&&next_powerUp==null){
			next_powerUp=powerUp.next();
		}
		if(clothing.hasNext()&&next_clothing==null){
			next_clothing = clothing.next();
		}
		return (next_food!=null||next_powerUp!=null||next_clothing!=null);
	}

	public Supplies next() {
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		Supplies next_supply = null;
		if(next_food!=null){
			next_supply=next_food;
		}
		if(next_powerUp!=null){
			if(next_supply==null){
				next_supply=next_powerUp;
			}else{
				if(compare.compare(next_supply, next_powerUp)>0){
					next_supply=next_powerUp;
				}
			}
		}
		if(next_clothing!=null){
			if(next_supply==null){
				next_supply = next_clothing;
			}else{
				if(compare.compare(next_supply,next_clothing)>0){
					next_supply = next_clothing;
				}
			}
		}
		if(next_supply==next_food){
			next_food=null;
		}else if (next_supply == next_powerUp){
			next_powerUp =null;
		}
		else if (next_supply == next_clothing){
			next_clothing = null;
		}
		return next_supply;
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}

}
