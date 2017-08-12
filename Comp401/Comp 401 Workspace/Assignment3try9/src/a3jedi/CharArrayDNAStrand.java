package a3jedi;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;

	public CharArrayDNAStrand(char[] base_array, String name) {
		for (int i = 0; i < base_array.length; i++) {
			if ((base_array[i] != 'C') 
					&& (base_array[i] != 'G')
					&& (base_array[i] != 'T') 
					&& (base_array[i] != 'A')) {
				throw new RuntimeException("Illegal");
			}
		}
		bases = base_array;
		this.name = name;
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
		} 
			this.name = name;
	}

	public char getBaseAt(int idx) {
		if (idx >= bases.length || idx < 0) {
			throw new RuntimeException("Illegal");
		} 
			return bases[idx];
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end || end >= bases.length) {
			throw new RuntimeException("Illegal");
		}
			char[] newChar = new char[end - start + 1];
			int counter = 0;
			for (int i = start; i <= end; i++) {
				newChar[counter] = bases[counter];
				counter++;
			}
			DNAStrand strand = new CharArrayDNAStrand(newChar);
			return strand;
	
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		} else {
			char[] newChar = new char[tail.getLength() + this.getLength()];

			for (int i = 0; i < newChar.length; i++) {
				if (i < this.getLength()) {
					newChar[i] = bases[i];
				} else {
					newChar[i] = tail.getBaseAt((i - this.getLength()));
				}
			}

			DNAStrand strand = new CharArrayDNAStrand(newChar);
			return strand;
		}
	}

	public int findSubstrand(DNAStrand substrand) {
		int find = substrand.getLength();
		int count = 0;

		for (int i = 0; i < getLength(); i++) {

			if (getBaseAt(i) == substrand.getBaseAt(0)) {

				for (int j = i; j < getLength(); j++) {
					if (getBaseAt(j) == substrand.getBaseAt(count)) {
						count++;
					} else {
						count = 0;
						break;
					}
					if (count == find) {
						return i;
					}
				}
			}

		}
		return -1;
	}

	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		int find = substrand.getLength();
		int count = 0;

		for (int i = search_start_position; i < getLength(); i++) {

			if (getBaseAt(i) == substrand.getBaseAt(0)) {

				for (int j = i; j < getLength(); j++) {
					if (getBaseAt(j) == substrand.getBaseAt(count)) {
						count++;
					} else {
						count = 0;
						break;
					}
					if (count == find) {
						return i;
					}
				}
			}

		}
		return -1;
	}
}