package a3adept;

public class StringDNAStrand implements DNAStrand {
	
	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {		
		if (base_string == null) {
			throw new RuntimeException ("Illegal");
		}
		for (int i = 0; i < base_string.length(); i++){
			char testCar = base_string.charAt(i);
			if ((testCar != 'C') && (testCar != 'G') && (testCar !='T') && (testCar != 'A')) {
				throw new RuntimeException("Illegal");
			}				
		}
		if (name == null) {
			name = "Unnamed";
		}
			else {
				this.name = name;
			}
		this.bases = base_string;
		}

	public StringDNAStrand(String strand_string) {
		this(strand_string, "Unnamed");
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			name = "Unnamed";
		}
		this.name = name;
		
	}

	public char getBaseAt(int idx) {
		if ((idx < 0) || (idx >= bases.length())) {
			throw new RuntimeException ("Illegal");
		}
		char baseChar = bases.charAt(idx);
		return baseChar;
	}

	public int getLength() {
		return bases.length();
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength()) || (start > end) || (start >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		return new ExtractedDNAStrand(this,start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		return new JoinedDNAStrand(this, tail);
	}

}
