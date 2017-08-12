package lec8.ex1.v2;

public class ProfessorImpl implements Professor {
    public static final int RANK_ASSISTANT = 0;
    public static final int RANK_ASSOCIATE = 1;
    public static final int RANK_FULL      = 2;

	private String first;
	private String last;
	private String address;
	private int rank;
	
	public ProfessorImpl(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
		rank = RANK_ASSISTANT;
	}
	
	public ProfessorImpl(String first, String last) {
		this(first, last, "Address Unknown");
	}

	public int getRank() {
		return rank;
	}
	
	public void promote() {
		switch (rank) {
		case RANK_ASSISTANT:
			rank = RANK_ASSOCIATE;
			break;
		case RANK_ASSOCIATE:
			rank = RANK_FULL;
			break;
		case RANK_FULL:
			// Can't go any higher than full.
		}
	}
	
	public String getFirstName() {
		return first;
	}

	public String getLastName() {
		return last;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addr) {
		address = addr;
	}

}
