package a3adept;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end, String name) {
		if (source_strand == null) {
			throw new RuntimeException ("Illegal");
		}
		if ((start < 0) || (end > source_strand.getLength()) || (start > end) || (start > source_strand.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		this.source_strand = source_strand;
		this.start = start;
		this.end = end;
		setName(name);
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
		this.name=name;
	}

	public char getBaseAt(int idx) { 
		if ((idx < 0) || (idx >= source_strand.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		int plusidx = start + idx;
		return source_strand.getBaseAt(plusidx);
	}
	public int getLength() {
		return (this.end - this.start + 1);
	}

	public DNAStrand extract(int start, int end) {
		if ((start > end) || (start < 0) || (end >= this.getLength()) || (start >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		DNAStrand extractedStrand = new ExtractedDNAStrand(this, start, end);
		return extractedStrand;
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		JoinedDNAStrand joinedStrand = new JoinedDNAStrand(this, tail);
		return joinedStrand;
	}
}