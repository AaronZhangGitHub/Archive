package person;

public class Student extends PersonImpl{
		
	// delegate to super constructor to set name, skill, etc
	public Student(String name) {
		super(name, (int)(Math.random()*41 + 80), (int)(Math.random()*41+30), Status.HEALTHY );
	}
	

	@Override
	public void special(){
		skill++;
	}

}
