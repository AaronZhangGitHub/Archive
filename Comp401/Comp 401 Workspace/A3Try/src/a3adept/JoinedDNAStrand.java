package a3adept;

public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;
	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		if ((head == null) || (tail == null)) {
			throw new RuntimeException ("Illegal");
		}
		if (name == null){
			this.name = "Unnamed";
			this.head = head;
			this.tail = tail;
		}
		else {
			this.name = name;
			this.head = head;
			this.tail = tail;
		}
	}

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		this(head, tail, "Unnamed");
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
		if ((idx < 0 ) || (idx >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		if (idx < head.getLength()) {
			return head.getBaseAt(idx);
		}
		else {
			return tail.getBaseAt(idx - head.getLength());
		}
	}

	public int getLength() {
		return (head.getLength() + tail.getLength());
	}

	public DNAStrand extract(int start, int end) {
		if ((start < 0) || (start > end) || (start >= this.getLength()) || (end >= this.getLength())) {
			throw new RuntimeException ("Illegal");
		}
		DNAStrand extractedStrand = new ExtractedDNAStrand(this, start, end);
		return extractedStrand;
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException ("Illegal");
		}
		return new JoinedDNAStrand(this, tail);
	}
}