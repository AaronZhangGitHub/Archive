package a4jedi;

public class Hacker extends PersonImpl {
	/*
	 *Characteristics of this person type are stated
	 */
	static final int MINHP = 60;
	static final int MAXHP = 100;
	static final int MINSKILL = 60;
	static final int MAXSKILL = 100;
	private boolean bmchecker = false;

	public Hacker(String name) {
		super(name, MINHP, MAXHP, MINSKILL, MAXSKILL);
	}

	@Override
	public void special() {
		//sets beast mode to on
		bmchecker = true;
	}

	public boolean beast_mode() {
		//returns if beast_mode is on or not
		return bmchecker;
	}
	@Override
	public void eat(Food food) throws NoFoodException {
		//eating food
		if(food==null){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		hp_current -= food.getFill();
		
		if(hp_current<0){
			hp_current=0;
		}
		if(hp_current>this.getMaxHP()){
			hp_current=this.getMaxHP();
		}
		
		food.consume();
	}
}
