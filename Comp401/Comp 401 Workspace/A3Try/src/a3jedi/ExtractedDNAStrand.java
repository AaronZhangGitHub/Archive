package a3jedi;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end,
			String name) {
		if ((start < 0) || (end > source_strand.getLength() + 1)
				|| (source_strand == null)) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}
		this.source_strand = source_strand;
		this.start = start;
		this.end = end;
	}

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end) {
		this(source_strand, start, end, "Unnamed");
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
		if ((idx < 0) || (idx > this.getLength())) {
			throw new RuntimeException(
					"Illegal-- idx < 0 or idx greater than length");
		}
		int plusidx = start + idx;
		return source_strand.getBaseAt(plusidx);
	}

	public int getLength() {
		return (end - start + 1);
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength())
				|| (start >= this.getLength())) {
			throw new RuntimeException("Illegal");
		}
		DNAStrand extractedStrand = new ExtractedDNAStrand(this, start, end);
		return extractedStrand;
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}
		JoinedDNAStrand joinedStrand = new JoinedDNAStrand(this, tail, name);
		return joinedStrand;
	}

	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null) {
			throw new RuntimeException("substrand is null");
		}
		return findSubstrand(substrand, 0);

	}

	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if ((substrand == null) || (search_start_position < 0)) {
			throw new RuntimeException("search start pos is Illegal");
		}
		// thisString and otherString appends them at the end.
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