package a3jedi;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end,String name) {
		
		if (source_strand == null) {
			throw new RuntimeException("Illegal");
		}
		
		if (start < 0 || start >= source_strand.getLength() || end <= 0
				|| end >= source_strand.getLength()) {
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

		char check;
		for (int i = 0; i < this.getLength(); i++) {
			check = this.getBaseAt(i);
			if (check != 'A' && check != 'C' && check != 'T' && check != 'G') {
				throw new RuntimeException("Illegal");
			}
		}
	}

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end) {
		this(source_strand, start, end, "Unnamed");
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
		
		DNAStrand extractedStrand = this.source_strand.extract(start, end);
		
		// account for start and end
		if (idx >= 0 && idx < this.getLength()) {
			return extractedStrand.getBaseAt(idx);
		} else {
			throw new RuntimeException("Illegal");
		}
	}

	public int getLength() {
		return (end - start) + 1;
	}

	public DNAStrand extract(int start, int end) {
		
		DNAStrand extractedStrand = this.source_strand.extract(this.start, this.end);
		
		if (start < 0 || start >= extractedStrand.getLength() || end <= 0|| end >= extractedStrand.getLength()) {
			throw new RuntimeException("Illegal");
		}

		return extractedStrand.extract(start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}
		DNAStrand extractedStrand = this.source_strand.extract(this.start, this.end);
		return new JoinedDNAStrand(extractedStrand,tail,"Unnamed");
	}
}