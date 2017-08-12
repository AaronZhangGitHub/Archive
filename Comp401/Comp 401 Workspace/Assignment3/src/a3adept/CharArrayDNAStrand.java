package a3adept;
public class CharArrayDNAStrand implements DNAStrand {
	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		if (base_array == null) {
			throw new RuntimeException ("Illegal");
		}
		for (int i = 0; i < base_array.length; i++){
			if ((base_array[i] != 'C') && (base_array[i] != 'G') && (base_array[i] != 'T') && (base_array[i] != 'A')) {
				throw new RuntimeException ("Illegal");
			}
		}
		if (name == null) {
			name = "Unnamed";
		}
			else {
				this.name = name;
			}
		this.bases = base_array;
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "Unnamed");
	}
	
	public String getName() {
		return this.name;	
	}

	public void setName(String name) {
		if (name == null) {
			name = "Unnamed";
		}
		this.name = name;
	}

	public char getBaseAt(int idx) {
		if ((idx < 0) || (idx >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		char baseChar = this.bases[idx];
		return baseChar;
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength()) || (start >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		return new ExtractedDNAStrand(this, start, end);
	}
	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		return new JoinedDNAStrand(this, tail);
	}
}
