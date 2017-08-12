package a4adept;

public class Student extends PersonImpl{
	/*
	 *Characteristics of this person type are stated
	 */
	static final int MINHP = 80;
	static final int MAXHP = 120;
	static final int MINSKILL = 30;
	static final int MAXSKILL = 70;
	public Student(String name) {
		super(name, MINHP, MAXHP, MINSKILL, MAXSKILL);
	}
	@Override
	public void special(){
		//increases skill by one
		skill+=1;
	}
}
