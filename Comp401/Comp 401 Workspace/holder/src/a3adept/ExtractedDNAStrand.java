package a3adept;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end,String name) {
		if (end < start) {
			throw new RuntimeException("Illegal");
		}
		if (source_strand == null) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			name = "Unnamed";
		} 
			this.name = name;

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
		// account for start and end
		if(idx<0||idx>=this.getLength()){
			throw new RuntimeException("Illegal");
		}
		return source_strand.getBaseAt(idx);
		/*
		if (idx >= 0 && idx < this.getLength()) {
			return source_strand.getBaseAt(idx);
		} else {
			throw new RuntimeException("Illegal");
		}
		*/
	}

	public int getLength() {
		return (end - start) + 1;
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start >= source_strand.getLength() || end <= 0|| end >= source_strand.getLength()) {
			throw new RuntimeException("Illegal");
		}

		return new ExtractedDNAStrand(source_strand.extract(start, end),start,end,"Unnamed");
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}
		return new JoinedDNAStrand(source_strand,tail,"Unnamed");
	}
}