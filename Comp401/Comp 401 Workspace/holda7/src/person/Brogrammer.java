package person;

public class Brogrammer extends PersonImpl{

	// delegate to super constructor to set name, skill, etc
	public Brogrammer(String name) {
		super(name,(int)(Math.random()*71 + 110),(int)(Math.random()*31 + 10), Status.HEALTHY );
	}

	@Override
	public void special() {
		setStatus(Status.HEALTHY);
	}

}
