package lec8.ex1.v3;

public class ProfessorImpl extends PersonImpl implements Professor {
    public static final int RANK_ASSISTANT = 0;
    public static final int RANK_ASSOCIATE = 1;
    public static final int RANK_FULL      = 2;

	private int rank;
	
	public ProfessorImpl(String first, String last, String address) {
		super(first, last, address);
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
}
