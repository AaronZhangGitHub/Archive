class Edge {
	private Node from;
	private Node to;
	private double weight;
	private String label;

	public Edge(Node f, Node t, double w) {
		from = f;
		to = t;
		weight = w;
	}

	public Node getfrom() {
		return from;
	}

	public Node getTo() {
		return to;
	}

	public double getWeight() {
		return weight;
	}
	public String getLabel() {
		return label;
	}

	public boolean hasLabel() {
		if (label == null) {
			return false;
		}
		return true;
	}
}
