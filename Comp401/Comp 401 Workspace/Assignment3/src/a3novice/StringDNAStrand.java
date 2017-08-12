package a3novice;

public class StringDNAStrand implements DNAStrand {

	private String bases;
	private String name;

	public StringDNAStrand(String base_string, String name) {
		if (base_string == null) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			this.name = "Unnamed";
		}
		bases = base_string;
		this.name = name;

		char check;
		for (int i = 0; i < this.getLength(); i++) {
			check = this.getBaseAt(i);
			if (check != 'A' && check != 'C' && check != 'T' && check != 'G') {
				throw new RuntimeException("Illegal");
			}
		}
		// System.out.println(bases);
	}

	public StringDNAStrand(String strand_string) {
		this(strand_string, "Unnamed");
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
		return bases.charAt(idx);
	}

	public int getLength() {
		return bases.length();
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start >= this.getLength() || end <= 0|| end >= this.getLength()) {
			throw new RuntimeException("Illegal");
		}

		String hold = "";
		int x = start;
		for (; x <= end; x++) {
			hold += getBaseAt(x);
		}
		return new StringDNAStrand(hold, "Unnamed");
	}

	public DNAStrand join(DNAStrand tail) {
		// test if null
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}

		String hold = "";
		for (int i = 0; i < tail.getLength(); i++) {
			hold += tail.getBaseAt(i);
		}
		return new StringDNAStrand(this.bases + hold, "Unnamed");
	}
}
