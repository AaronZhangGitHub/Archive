import java.util.ArrayList;

class Node {

	private String name;
	private Node next;
	private int serialNumber;
	private Edge adj;
	private int inDeg;
	private double shortestPathFromSource;
	private Node pred;
	private boolean handled;
	private ArrayList<Edge> edgeHolder = new ArrayList<Edge>();
	private double xVal;
	private double yVal;

	public Node(int sn, double xVal, double yVal) {
		this.serialNumber = sn;
		this.xVal = xVal;
		this.yVal= yVal;
		this.shortestPathFromSource = Integer.MAX_VALUE;
		pred = null;
		handled = false;

	}
	public double getX(){
		return xVal;
	}
	public double getY(){
		return yVal;
	}
	public boolean handled() {
		return handled;
	}

	public void handle() {
		handled = true;
	}

	public double getShortestPathFromSource() {
		return shortestPathFromSource;
	}

	public void setShortestPathFromSource(double s) {
		shortestPathFromSource = s;
	}

	public void setPred(Node p) {
		pred = p;
	}

	public Node getPred() {
		return pred;
	}

	public int getSerialNum() {
		return serialNumber;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void addEdge(Edge e) {
		//The edges coming out of this node, to another node
		edgeHolder.add(e);
	}

	public int numEdgesOutOf() {
		return edgeHolder.size();
	}


	public boolean hasEdge() {
		if (edgeHolder.size() > 0) {
			return true;
		}
		return false;
	}

	public Edge returnEdge(int i) {
		return edgeHolder.get(i);
	}

	public boolean removeEdge(Node deleteNode) {
		for (int i = 0; i < edgeHolder.size(); i++) {
			if (deleteNode.name.equals(edgeHolder.get(i).getTo().name)) {
				// Edge exists to be deleted
				deleteNode.decInDeg();
				// Delete Edge
				edgeHolder.remove(edgeHolder.get(i));
				// Return True
				return true;
			}
		}
		return false;
	}

	public void incInDeg() {
		inDeg++;
	}

	public void decInDeg() {
		if (inDeg > 0) {
			inDeg--;
		}
	}

	public int getInDeg() {
		return inDeg;
	}

	public void decInDegEdgesOut() {
		for (int i = 0; i < edgeHolder.size(); i++) {
			edgeHolder.get(i).getTo().decInDeg();
		}
	}
}