package a3novice;

public class StringDNAStrand implements DNAStrand {
	
	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {		
		if (base_string == null){
			throw new RuntimeException ("Illegal");
		}
		for (int i = 0; i < base_string.length(); i++){
			char testCar = base_string.charAt(i);
			if ((testCar != 'C') && (testCar != 'G') && (testCar != 'T') && (testCar != 'A')) {
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
		else {
			this.name = name;	
		}
	}
	public char getBaseAt(int idx) {
		if ((idx < 0) || (idx >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		char baseChar = bases.charAt(idx);
		return baseChar;
	}
	public int getLength() {
		return bases.length();
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength()) || (start >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		StringBuilder strBuilder = new StringBuilder("");
		for (int i = start; i <= end; i++) {
			strBuilder.append(this.getBaseAt(i));
		}
		//String sub_string = this.bases.substring(start, end);
		//DNAStrand Unnamed = new StringDNAStrand(sub_string);
		String finalString = strBuilder.toString();
		return new StringDNAStrand(finalString);
	}
	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		StringBuilder strBuilder = new StringBuilder("");
		
		for (int i = 0; i < this.getLength(); i++) {
			strBuilder.append(this.getBaseAt(i));
		}
		for (int j = 0; j < tail.getLength(); j++){
			strBuilder.append(tail.getBaseAt(j));
		}
		/*String joinString = "";
		for (int i = 0; i < tail.getLength(); i++) {
			joinString += tail.getBaseAt(i);
		}
		String finalString = this.bases + joinString; 
		DNAStrand Unnamed = new StringDNAStrand(finalString);*/
		String finalString = strBuilder.toString();
		return new StringDNAStrand(finalString);
	}
}
