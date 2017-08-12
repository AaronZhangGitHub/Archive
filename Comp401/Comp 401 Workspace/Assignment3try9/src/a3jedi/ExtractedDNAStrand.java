package a3jedi;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end,
			String name) {

		if (source_strand == null) {
			throw new RuntimeException("Illegal");
		}
		if (start < 0 || start > end || end >= source_strand.getLength()) {
			throw new RuntimeException("Illegal");
		}

		this.source_strand = source_strand;
		this.start = start;
		this.end = end;
		this.name = name;

		source_strand.extract(start, end);
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
		if (idx >= getLength()) {
			throw new RuntimeException("Illegal");
		}

		return source_strand.getBaseAt(idx + start);
	}

	public int getLength() {
		return end - start+1;
	}

	public DNAStrand extract(int start, int end) {
		return source_strand.extract(this.start + start, this.start + end);
	}

	public DNAStrand join(DNAStrand tail) {
		if(tail == null){
			throw new RuntimeException("Illegal");
		}
		return new JoinedDNAStrand(source_strand.extract(start, end), tail);
	}

	public int findSubstrand(DNAStrand substrand) {
		return source_strand.extract(start, end).findSubstrand(substrand);
	}

	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		return source_strand.extract(start, end).findSubstrand(substrand, search_start_position);

	}
}