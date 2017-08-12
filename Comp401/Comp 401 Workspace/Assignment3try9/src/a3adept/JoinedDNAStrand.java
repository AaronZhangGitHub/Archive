package a3adept;

public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		if (head == null || tail == null) {
			throw new RuntimeException("Illegal");
		}

		this.head = head;
		this.tail = tail;
		if (name == null) {
			this.name = "Unnamed";
		} else {
			this.name = name;
		}

	}

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		this(head, tail, "Unnamed");
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
		if (idx >= getLength() || idx < 0) {
			throw new RuntimeException("Illegal");
		}

		if (idx >= head.getLength()) {
			return tail.getBaseAt(idx - head.getLength());
		} else {
			return head.getBaseAt(idx);
		}
	}

	public int getLength() {
		return head.getLength() + tail.getLength();
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start > end || end >= getLength()) {
			throw new RuntimeException("Illegal");
		} else {
			return new ExtractedDNAStrand(head.join(tail), start, end);
		}
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		}
		return new JoinedDNAStrand(head.join(this.tail), tail);
	}
}