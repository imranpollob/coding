import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UnweightedShortestPath {

	public static void main(String[] args) {
		int V = 4;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(V);
		
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 0);
		
		printGraph(graph);
//		System.out.println(graph);
		
		bfsShortestPath(graph, 0);
	}

	private static void bfsShortestPath(ArrayList<ArrayList<Integer>> graph, int s) {
		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] distance = new int[graph.size()];
		
		visited[s] = true;
		queue.add(s);
		distance[s] = 0;
		
		System.out.print("BFS: ");
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			System.out.print(node + " ");

			for (int i = 0; i < graph.get(node).size(); i++) {
				int temp = graph.get(node).get(i);
				
				if (visited[temp] == false) {
					queue.add(temp);
					visited[temp] = true;
					distance[temp] = distance[node] + 1;
				}
			}
		}
		
		System.out.println("\nDistance array:" + Arrays.toString(distance));
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int v) {
		graph.get(s).add(v);
	}

}
