package a3jedi;


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
		} else {
				this.name = name;
			}
		this.bases = base_array;
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "Unnamed");
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
		if ((idx < 0) || (idx >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		char baseChar = bases[idx];
		return baseChar;
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength()) || (start >= this.getLength())) {
			throw new RuntimeException ("Start and End are Illegal");
		}
		return new ExtractedDNAStrand(this, start, end);
	}
	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		return new JoinedDNAStrand(this, tail);
	}
	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null) {
			throw new RuntimeException ("substrand is null");
		}
		return findSubstrand(substrand, 0);
	}
	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if ((substrand == null) || (search_start_position < 0)) {
			throw new RuntimeException ("search start pos is Illegal");
		}
		//two strings to append them at the end. thisString and otherString
		StringBuilder thisString = new StringBuilder("");
		StringBuilder otherString = new StringBuilder("");
		
		for (int i = 0; i < this.getLength(); i++) {
			thisString.append(this.getBaseAt(i));
		}
		for (int j = 0; j < substrand.getLength(); j++) {
			otherString.append(substrand.getBaseAt(j));		
		}
		String firstString = thisString.toString();
		String subString = otherString.toString();
		return firstString.indexOf(subString, search_start_position);
	}
}
