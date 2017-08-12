package a3adept;

public class StringDNAStrand implements DNAStrand {

	private String bases;
	private String name;

	public StringDNAStrand(String base_string, String name) {
		for (int i = 0; i < base_string.length(); i++) {
			if ((base_string.charAt(i) != 'C')
					&& (base_string.charAt(i) != 'G')
					&& (base_string.charAt(i) != 'T')
					&& (base_string.charAt(i) != 'A')) {
				throw new RuntimeException("Illegal");
			}
		}
		bases = base_string;
		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}

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
		if (idx >= bases.length() || idx < 0) {
			throw new RuntimeException("Illegal");
		} else {
			return bases.charAt(idx);
		}
	}

	public int getLength() {
		return bases.length();
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end || end >= bases.length()) {
			throw new RuntimeException("Illegal");
		} else {
			return new ExtractedDNAStrand(new StringDNAStrand(bases), start,end);
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		} else {
			return new JoinedDNAStrand(new StringDNAStrand(bases), tail);
		}
	}

}