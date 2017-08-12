import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ArrayList<String> listOfStrings = new ArrayList<String>();
		ArrayList<Node> listOfNodes = new ArrayList<Node>();
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		Map m = new Map();
		String fileName = "p2graphData.txt";
		String line = null;
		int nodeNumber = 0;
		int edgeNumber = 0;
		boolean checker = true;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				listOfStrings.add(line); // Arraylist containing all of the
											// strings of lines
			}
			
			for (int i = 0; i < listOfStrings.size(); i++) {
				if (listOfStrings.get(i).isEmpty()) {
					continue;
				}

				// Record the number of edges and nodes
				if (checker) {
					// First line of input hasn't been recorded yet
					String[] ss = listOfStrings.get(i).split("\\s+");
					nodeNumber = Integer.parseInt(ss[0]);
					edgeNumber = Integer.parseInt(ss[1]);
					checker = false;
					continue;
				}

				
				if (nodeNumber > 0) {
					// Create nodes with X, Y
					String s[] = listOfStrings.get(i).split("\\s+");
					int serialNum = Integer.parseInt(s[0]);
					double xVal = Integer.parseInt(s[1]);
					double yVal = Integer.parseInt(s[2]);
					Node node = new Node(serialNum,xVal,yVal);
					listOfNodes.add(node);
					m.addNode(node);
					nodeNumber--;
				}else if (nodeNumber == 0 && edgeNumber > 1) {
					
					String s[] = listOfStrings.get(i).split("\\s+");
					int vert1 = Integer.parseInt(s[0]);
					int vert2 = Integer.parseInt(s[1]);
					//Get both nodes using serial numbers
					Node n1 = listOfNodes.get(vert1);
					Node n2 = listOfNodes.get(vert2);
					//Calculate distance between the nodes
					double distance =Math.sqrt( Math.pow(n1.getX()-n2.getX(),2) + Math.pow(n1.getY()-n2.getY(), 2) );
					distance = Math.round(distance*10);
					distance = distance/10;
					
					//Create an edge between the nodes
					Edge edge1 = new Edge(n1,n2,distance);
					Edge edge2 = new Edge(n2,n1,distance);
					listOfEdges.add(edge1);
					
					n1.addEdge(edge1);//signals there is a node coming out of n1
					n2.addEdge(edge2);//signals there is a node coming out of n2

					edgeNumber--;
				}
				if (nodeNumber == 0 && edgeNumber == 1) {
					//identify source and destination edge
					String s[] = listOfStrings.get(i).split("\\s+");
					int source = Integer.parseInt(s[0]);
					int dest = Integer.parseInt(s[1]);

					Node sourceNode = listOfNodes.get(source);
					Node destNode = listOfNodes.get(dest);
					
					m.setSource(sourceNode);
					m.setDest(destNode);
					
				}
			}
			
			m.shortestPathDijkstra();
			
			
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Run time: "+ totalTime);
	}
}