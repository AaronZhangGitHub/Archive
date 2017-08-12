package person;

public class Brogrammer extends PersonImpl{
	/*
	 *Characteristics of this person type are stated
	 */
	static final int MINHP = 110;
	static final int MAXHP = 180;
	static final int MINSKILL = 10;
	static final int MAXSKILL = 40;
	public Brogrammer(String name) {
		super(name, MINHP, MAXHP, MINSKILL, MAXSKILL);
	}
	@Override
	public void special(){
		//sets status to healthy
		setStatus(Person.Status.HEALTHY);
	}
}
