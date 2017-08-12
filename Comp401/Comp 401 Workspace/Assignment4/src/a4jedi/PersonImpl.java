package a4jedi;

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
		this.skill_max = randomization(minskill,maxskill); //randomizes the skill maximum between the skill range given
		hp_max = randomization(minhp,maxhp);//randomizes the health maximum between the health ranges given
		this.hp_current = this.hp_max;
		this.skill = skill_max;
		status = Person.Status.HEALTHY;//sets persons status to healthy
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
		food.consume();//consumes the food (foodimpl)
		hp_current += food.getFill();//adds fill to the hp
		
		if(hp_current<0){
			//sets current hp to 0 if it is less than zero
			hp_current = 0;
		}
		if(hp_current>hp_max){
			//does not let hp go above max
			hp_current = hp_max;
		}
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Person.Status new_status) {
		if(new_status == null){
			//if new_status is null throws an exception
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		status = new_status;
	}

	public String getName() {
		return name;
	}

	public abstract void special(); //abstract, to be done in each child

	public int randomization(int min, int max){
		//randomizes by taking two intergers
		//finding the range between the integers
		//multiplying the range by a random number
		//rounding that range
		//and adding it to the minimum
		//then converting it back to an integer from double
		return (int)(min+Math.round(Math.random()*(max-min)));
	}
}
