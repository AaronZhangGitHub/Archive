package a3jedi;

public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		if (head == null || tail == null) {
			throw new RuntimeException("Illegal");
		}
		if (name == null) {
			this.name = "Unnamed";
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
		
		DNAStrand joinedStrand = head.join(tail);
		
		if (idx < 0 || idx >= joinedStrand.getLength()) {
			throw new RuntimeException("Illegal");
		} else {
			return joinedStrand.getBaseAt(idx);
		}
	}

	public int getLength() {
		return head.join(tail).getLength();
	}

	public DNAStrand extract(int start, int end) {
		
		DNAStrand joinedStrand = head.join(tail);
		if (start < 0 || start >= joinedStrand.getLength() || end <= 0|| end >= joinedStrand.getLength()) {
			throw new RuntimeException("Illegal");
		}
		return joinedStrand.extract(start, end);
	}
	

	public DNAStrand join(DNAStrand tail) {
		if (tail == null) {
			throw new RuntimeException("Illegal");
		} else {
			return   new JoinedDNAStrand(this,tail, "Unnamed") ;
		}
			
		
	}
}