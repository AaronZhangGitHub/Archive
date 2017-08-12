package a3novice;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;

	public CharArrayDNAStrand(char[] base_array, String name) {
		for (int i = 0; i < base_array.length; i++) {
			if ((base_array[i] != 'C') && (base_array[i] != 'G')
					&& (base_array[i] != 'T') && (base_array[i] != 'A')) {
				throw new RuntimeException("Illegal");
			}

		}
		bases = base_array;

		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
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
		if (idx >= getLength() || idx < 0) {
			throw new RuntimeException("Illegal");
		} else {
			return bases[idx];
		}
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end || end >= getLength()) {
			throw new RuntimeException("Illegal");
		} else {
			char[] newChar = new char[end - start + 1];
			int counter = 0;
			for (int i = start; i <= end; i++) {
				newChar[counter] = bases[i];
				counter++;
			}
			CharArrayDNAStrand strand = new CharArrayDNAStrand(newChar);
			return strand;
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		} else {
			char[] newChar = new char[this.getLength() + tail.getLength()];
			for (int i = 0; i < this.getLength(); i++) {
				newChar[i] = this.getBaseAt(i);
			}
			int j = 0;
			for (int i = this.getLength(); i < this.getLength() + tail.getLength(); i++) {
				newChar[i] = tail.getBaseAt(j);
				j++;
			}
			return new CharArrayDNAStrand(newChar);
		}

	}

}