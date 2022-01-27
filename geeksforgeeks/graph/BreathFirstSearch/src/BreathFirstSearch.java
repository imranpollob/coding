import java.util.ArrayList;

public class BreathFirstSearch {

	public static void main(String[] args) {
		int total_vertices = 6;
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>(total_vertices + 1);
		
		for (int i = 0; i <= total_vertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}

		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 1, 3);
		addEdge(adjacencyList, 2, 1);
		addEdge(adjacencyList, 2, 4);
		addEdge(adjacencyList, 2, 5);
		addEdge(adjacencyList, 3, 1);
		addEdge(adjacencyList, 3, 5);
		addEdge(adjacencyList, 4, 2);
		addEdge(adjacencyList, 4, 5);
		addEdge(adjacencyList, 4, 6);
		addEdge(adjacencyList, 5, 2);
		addEdge(adjacencyList, 5, 3);
		addEdge(adjacencyList, 5, 4);
		addEdge(adjacencyList, 5, 6);
		addEdge(adjacencyList, 6, 4);
		addEdge(adjacencyList, 6, 5);
		
		printGraph(adjacencyList);
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
		for (int i = 0; i < adjacencyList.size(); i++) {
			for (int j = 0; j < adjacencyList.get(i).size(); j++) {
				System.out.print(adjacencyList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
		adjacencyList.get(source).add(destination);
	}

}
