package a3novice;
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
		return name;	
	}

	public void setName(String name) {
		if (name == null) {
			name = "Unnamed";
		}
		this.name = name;
	}

	public char getBaseAt(int idx) {
		if ((idx < 0) || (idx >= bases.length)) {
			throw new RuntimeException ("Illegal");
		}
		return bases[idx];
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= bases.length)) {
			throw new RuntimeException ("Illegal");
		}
		StringBuilder strBuilder = new StringBuilder("");
		for (int i = start; i <= end; i++) {
			strBuilder.append(this.getBaseAt(i));
		}
		String finalString = strBuilder.toString();
		//char [] c = Arrays.copyOfRange(bases, start, end+1);
		return new StringDNAStrand(finalString);
	}
	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		StringBuilder strBuilder = new StringBuilder("");
		
		//char[] tailBases = new char[tail.getLength()];
		for (int i = 0; i < this.getLength(); i++) {
			strBuilder.append(this.getBaseAt(i));
		}
		for (int j = 0; j < tail.getLength(); j++){
			strBuilder.append(tail.getBaseAt(j));
		}
		//char [] joinArray = new char[tailBases.length + bases.length];
		/*for (int j = 0; j < bases.length; j++) {
			joinArray[j] = bases[j];
		}
		for (int j = bases.length; j < joinArray.length; j++) {
			joinArray[j] = tailBases[j - bases.length]; 
		}*/
		String finalString = strBuilder.toString();
		return new StringDNAStrand(finalString);
	}
}
