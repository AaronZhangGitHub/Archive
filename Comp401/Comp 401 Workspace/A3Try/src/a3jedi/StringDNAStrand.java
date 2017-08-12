package a3jedi;

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
		/*String substring = this.bases.substring(start, end-1);
		DNAStrand extractString = new StringDNAStrand(substring);
		return extractString;*/
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		return new JoinedDNAStrand(this, tail);
		/*String joinString = "";
		for (int i = 0; i < tail.getLength(); i++) {
			joinString += tail.getBaseAt(i);
		}
		String finalString = this.bases + joinString; 
		DNAStrand Unnamed = new StringDNAStrand(finalString);
		return Unnamed;*/
	}
	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null) {
			throw new RuntimeException ("substrand is null");
		}
		return findSubstrand(substrand, 0);
		/*StringBuilder thisString = new StringBuilder("");
		StringBuilder otherString = new StringBuilder("");
		
		for (int i = 0; i < this.getLength(); i++) {
			thisString.append(this.getBaseAt(i));
		}
		for (int j = 0; j < substrand.getLength(); j++) {
			otherString.append(substrand.getBaseAt(j));		
		}
		String firstString = thisString.toString();
		String subString = otherString.toString();
		return firstString.indexOf(subString);*/
	}
	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if ((substrand == null) || (search_start_position < 0)) {
			throw new RuntimeException ("search start pos is Illegal");
		}
		StringBuilder thisString = new StringBuilder("");
		StringBuilder otherString = new StringBuilder("");
		
		for (int i = 0; i < this.getLength(); i++) {
			thisString.append(this.getBaseAt(i));
		}
		for (int j = 0; j < substrand.getLength(); j++) {
			otherString.append(substrand.getBaseAt(j));		
		}
		String firstString = thisString.toString();
	//	String firstStringCut = firstString.substring(search_start_position);
		String subString = otherString.toString();
		return firstString.indexOf(subString,search_start_position);
	}
}
