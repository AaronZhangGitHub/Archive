package a3jedi;

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
		this.name = name;

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
			StringDNAStrand strand = new StringDNAStrand(bases.substring(start,
					end + 1));
			return (DNAStrand) strand;
		}

	}

	public DNAStrand join(DNAStrand tail) {

		if (tail == null) {
			throw new RuntimeException("Illegal");
		}

		char[] array = new char[tail.getLength()];

		for (int i = 0; i < tail.getLength(); i++) {
			array[i] = tail.getBaseAt(i);
		}

		String s = new String(array);

		return new StringDNAStrand(bases + s);
	}

	public int findSubstrand(DNAStrand substrand) {
		int find = substrand.getLength();
		int count = 0;

		for (int i = 0; i < getLength(); i++) {

			if (getBaseAt(i) == substrand.getBaseAt(0)) {
				
				for (int j = i; j < getLength(); j++) {
					if(getBaseAt(j) == substrand.getBaseAt(count)){
						count++;
					}
					else{
						count = 0;
						break;
					}
					if(count == find){
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
					if(getBaseAt(j) == substrand.getBaseAt(count)){
						count++;
					}
					else{
						count = 0;
						break;
					}
					if(count == find){
						return i;
					}
				}
			}

		}
		return -1;
	}

}