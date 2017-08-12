package a3adept;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;

	public CharArrayDNAStrand(char[] base_array, String name) {
		if (base_array == null) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}
		bases = base_array;
		if (bases == null) {
			throw new RuntimeException("Illegal");
		}
		char check;
		for (int i = 0; i < this.getLength(); i++) {
			check = this.getBaseAt(i);
			if (check != 'A' && check != 'C' && check != 'T' && check != 'G') {
				throw new RuntimeException("Illegal");
			}
		}
	}

	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "Unnamed");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}
	}

	public char getBaseAt(int idx) {

		if (idx < 0 || idx >= this.getLength()) {
			throw new RuntimeException("Illegal");
		}
		return bases[idx];
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {

		if (start < 0 || start >= this.getLength() || end <= 0
				|| end >= this.getLength()) {
			throw new RuntimeException("Illegal");
		}

		char[] hold = new char[(end - start) + 1];

		int x = 0;

		for (int i = start; i <= end; i++) {
			hold[x] = getBaseAt(i);
			x++;
		}
		return new CharArrayDNAStrand(hold, "Unnamed");

	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}

		int newLength = tail.getLength() + this.getLength();

		int tailLength = tail.getLength();

		char[] newBases = new char[newLength];

		for (int i = 0; i < this.getLength(); i++) {
			newBases[i] = this.getBaseAt(i);
		}

		int x = 0;
		for (int j = this.getLength(); j < newLength; j++) {
			newBases[j] = this.getBaseAt(x++);
		}
		;

		return new CharArrayDNAStrand(newBases, "Unnamed");
	}

	@Override
	public int findSubstrand(DNAStrand substrand) {

		return this.findSubstrand(substrand, 0);
	}

	@Override
	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if (substrand == null || search_start_position < 0
				|| search_start_position >= this.getLength()) {
			throw new RuntimeException("Illegal");
		}

		String thisBases = "";
		for (int i = 0; i < this.getLength(); i++) {
			thisBases += this.getBaseAt(i);
		}

		String subBases = "";
		for (int j = 0; j < substrand.getLength(); j++) {
			subBases += substrand.getBaseAt(j);
		}

		return thisBases.indexOf(subBases, search_start_position);
	}
}
