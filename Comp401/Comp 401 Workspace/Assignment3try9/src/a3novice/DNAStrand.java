package a3novice;

public interface DNAStrand {
	String getName();

	void setName(String name);

	char getBaseAt(int idx);

	int getLength();

	DNAStrand extract(int start, int end);

	DNAStrand join(DNAStrand tail);

}
