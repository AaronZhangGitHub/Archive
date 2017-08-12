package person;

import supplies.Food;
import supplies.NoFoodException;

abstract public class PersonImpl implements Person{
	protected int hp_current;
	private final int hp_max;
	protected final int skill_max;
	protected int skill;
	private String name;
	private Status status;
	protected PersonImpl(String name, int minhp, int maxhp, int minskill, int maxskill){
		if(name==null){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		this.name = name;
		this.skill_max = randomization(minskill,maxskill);
		hp_max = randomization(minhp,maxhp);
		this.hp_current = this.hp_max;
		this.skill = skill_max;
		status = Person.Status.HEALTHY;
	}

	public int getCurrentHP() {
		return hp_current;
	}

	public int getMaxHP() {
		return hp_max;
	}

	public int getSkill() {
		return skill;
	}

	public void eat(Food food) throws NoFoodException {
		if(food==null){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		food.consume();
		hp_current += food.getFill();
		
		if(hp_current<0){
			hp_current = 0;
		}
		if(hp_current>hp_max){
			hp_current = hp_max;
		}
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Person.Status new_status) {
		if(new_status == null){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		status = new_status;
	}

	public String getName() {
		return name;
	}

	public abstract void special();

	public int randomization(int min, int max){
		return (int)(min+Math.round(Math.random()*(max-min)));
	}
}
