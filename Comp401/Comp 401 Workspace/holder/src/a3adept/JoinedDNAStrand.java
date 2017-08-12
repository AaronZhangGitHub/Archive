package a3adept;

public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		if (head == null || tail == null) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			name = "Unnamed";
		}
		this.head = head;
		this.tail = tail;
		this.name = name;

		char check;
		for (int i = 0; i < this.getLength(); i++) {
			check = this.getBaseAt(i);
			if (check != 'A' && check != 'C' && check != 'T' && check != 'G') {
				throw new RuntimeException("Illegal");
			}
		}
	}

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		this(head,tail,"Unnamed");
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
		int x = head.join(tail).getLength();
		if(idx < 0 || idx >= x){
			throw new RuntimeException("Illegal");
		}
		return head.join(tail).getBaseAt(idx);
		/*
		if (idx < 0 || idx >= x) {
			throw new RuntimeException("Illegal");
		} else {
			return head.join(tail).getBaseAt(idx);
		}
		*/
	}

	public int getLength() {
		return head.join(tail).getLength();
	}

	public DNAStrand extract(int start, int end) {
		if (start < 0 || start >= head.join(tail).getLength() || end <= 0|| end >= head.join(tail).getLength()) {
			throw new RuntimeException("Illegal");
		}
		return new ExtractedDNAStrand(head.join(tail).extract(start, end),start,end,"Unnamed");
	}

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		} else {
			return new JoinedDNAStrand(head.join(tail),tail,"Unnamed");
		}
	}
}