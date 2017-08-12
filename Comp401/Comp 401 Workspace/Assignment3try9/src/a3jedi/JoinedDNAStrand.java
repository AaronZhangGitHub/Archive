package a3jedi;

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
		this.name = name;

		head.join(tail);
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
		if (idx >= getLength()) {
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
		return new ExtractedDNAStrand(head.join(tail), start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		if(tail == null){
			throw new RuntimeException("Illegal");
		}
		return new JoinedDNAStrand(head.join(this.tail), tail);
	}

	public int findSubstrand(DNAStrand substrand) {
		return head.join(tail).findSubstrand(substrand);
	}

	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		return head.join(tail).findSubstrand(substrand, search_start_position);
	}
}