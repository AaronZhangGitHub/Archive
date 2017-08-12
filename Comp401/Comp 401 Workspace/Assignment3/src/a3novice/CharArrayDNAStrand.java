package a3novice;

public class CharArrayDNAStrand implements DNAStrand {

	private char[] bases;
	private String name;

	public CharArrayDNAStrand(char[] base_array, String name) {
		if(name==null){
			this.name="Unnamed";
		}
		this.name = name;
		bases = base_array;
		if(bases==null){
			throw new RuntimeException("Illegal");
		}
		char check;
		for(int i = 0;i<this.getLength();i++){
			check = this.getBaseAt(i);
			if(check!='A'&&check!='C'&&check!='T'&&check!='G'){
				throw new RuntimeException("Illegal");
			}
		}
	}

	public CharArrayDNAStrand(char[] base_array) {
		this(base_array, "Unnamed");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name==null){
			this.name="Unnamed";
		}
		else{
			this.name = name;
		}
	}

	public char getBaseAt(int idx) {

		if (idx < 0 || idx >= this.getLength()) {
			throw new RuntimeException("Illegal");
		}
		return bases[idx];
	}

	public int getLength() {
		return bases.length;
	}

	public DNAStrand extract(int start, int end) {
		
		if(start<0||start>=this.getLength()||end<=0||end>=this.getLength()){
			throw new RuntimeException("Illegal");
		}
		
		char[] hold = new char[(end - start)+1];
		int x = 0;
		for (; start <= end; start++) {
			hold[x] = getBaseAt(start);
			x++;
		}
		return new CharArrayDNAStrand(hold, "Unnamed");
		
	}

	public DNAStrand join(DNAStrand tail) {
		if(tail==null){
			throw new RuntimeException("Illegal");	
		}
		
		int x = tail.getLength() + this.getLength();
		int x1 = tail.getLength();
		char [] tailhold = new char[x1];
		for(int i = 0;i<x1;i++){
			tailhold[i]=tail.getBaseAt(i);
		}
		char[] hold = new char[x];
		
		System.arraycopy(bases,0,hold,0,bases.length);
		System.arraycopy(tailhold,0,hold,bases.length,tailhold.length);
		
		return new CharArrayDNAStrand(hold,"Unnamed");
	}
}