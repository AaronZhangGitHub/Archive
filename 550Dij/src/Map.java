import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Map {
	ArrayList<Node> nodesArrayList = new ArrayList<Node>();
	ArrayList<String> vertexNames = new ArrayList<String>();
	int vertEx;

	private Node sourceNode;
	private Node destNode;

	public Map() {
	}

	public void addNode(Node node) {
		nodesArrayList.add(node);
	}
	public void setSource(Node source) {
		sourceNode = source;
	}
	public void setDest(Node dest){
		destNode = dest;
	}

	public void shortestPathDijkstra() {
		PriorityQueue<Double> pq = new PriorityQueue<Double>(nodesArrayList.size());
		ArrayList<Double> key = new ArrayList<Double>();
		ArrayList<Node> val = new ArrayList<Node>();
		
		sourceNode.setShortestPathFromSource(0); // From Source to Source length is 0
		pq.add(sourceNode.getShortestPathFromSource()); // Source node put in the queue
		
		key.add(0.0);
		val.add(sourceNode);
		
		while (!pq.isEmpty()) {
			double s = pq.peek(); 
			pq.remove();
			int inde = key.indexOf(s);
			key.remove(inde);
			Node n = val.get(inde);
			val.remove(inde);

			if (n.handled()) {
				continue;
			}
			n.handle();
			vertEx++;
			for (int i = 0; i < n.numEdgesOutOf(); i++) {
				// Each edge coming out of it
				
				if (!n.returnEdge(i).getTo().handled()) {// If the node the edge
															// is going into is
															// handled
					double pathLength = n.getShortestPathFromSource() + n.returnEdge(i).getWeight();
					if (pathLength < n.returnEdge(i).getTo().getShortestPathFromSource()) {
						n.returnEdge(i).getTo().setShortestPathFromSource(pathLength);
						n.returnEdge(i).getTo().setPred(n);
						pq.add(pathLength);
						key.add(pathLength);
						val.add(n.returnEdge(i).getTo());
					}
				}
			}
		}
		
		//printing sequence
		Node temp = destNode;
		System.out.println("Destination Node: "+destNode.getSerialNum());
		while(true){
			System.out.println("Node: "+ temp.getSerialNum() +" Shortest Path Form Source: "+temp.getShortestPathFromSource());
			if(temp.getPred()==null){
				System.out.println("From Source Node: "+temp.getSerialNum());
				break;
			}
			temp = temp.getPred();
		}
		System.out.println("Vert Ex "+vertEx);
	}
}
	