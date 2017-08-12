package lec8.ex1.v3;

public class StudentImpl extends PersonImpl implements Student {
    public static final int STATUS_FRESHMAN  = 0;
    public static final int STATUS_SOPHOMORE = 1;
    public static final int STATUS_JUNIOR    = 2;
    public static final int STATUS_SENIOR    = 3;

	private int credits;
	
	public StudentImpl(String first, String last, String address) {
		super(first, last, address);
		credits = 0;
	}
	
	public StudentImpl(String first, String last) {
		this(first, last, "Address Unknown");
	}

	public void addCredits(int num_credits) {
		credits += num_credits;
	}

	public int getStatus() {
		if (credits < 30) {
			return STATUS_FRESHMAN;
		} else if (credits < 60) {
			return STATUS_SOPHOMORE;
		} else if (credits < 90) {
			return STATUS_JUNIOR;
		}
		return STATUS_SENIOR;
	}
}
