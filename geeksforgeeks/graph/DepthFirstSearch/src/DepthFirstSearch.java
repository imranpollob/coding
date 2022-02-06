import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch {

	public static void main(String[] args) {
		int total_vertices = 7;
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>(total_vertices + 1);

		for (int i = 0; i <= total_vertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}

		// we are implicitly defining the paths
		// only defining a edge from 1 to 2 with also create a edge from 2 to 1  
		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 1, 3);
		addEdge(adjacencyList, 2, 4);
		addEdge(adjacencyList, 2, 5);
		addEdge(adjacencyList, 3, 6);
		addEdge(adjacencyList, 3, 7);

		printGraph(adjacencyList);

		System.out.println("DFS: ");
		dfs(adjacencyList, 1);
		System.out.println("\nDFS Recursive: ");
		boolean[] visited = new boolean[adjacencyList.size()];
		dfsRec(adjacencyList, 1, visited);
	}

	private static void dfsRec(ArrayList<ArrayList<Integer>> adjacencyList, int node, boolean[] visited) {
		// As its a void method so no base return case is needed
		visited[node] = true;
		System.out.print(node + " ");

		for (int i = 0; i < adjacencyList.get(node).size(); i++) {
			int temp = adjacencyList.get(node).get(i);
			if (visited[temp] == false) {
				dfsRec(adjacencyList, temp, visited);
			}
		}
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int root) {
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[adjacencyList.size()];

		stack.push(root);

		while (!stack.isEmpty()) {
			int tail = stack.lastElement();

			if (visited[tail] == 0) {
				System.out.print(tail + " ");
				visited[tail] = 1;
			}

			int flag = 0;

			for (int i = 0; i < adjacencyList.get(tail).size(); i++) {
				int node = adjacencyList.get(tail).get(i);

				if (visited[node] == 0) {
					stack.push(node);
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				stack.pop();
			}
		}
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
		for (int i = 1; i < adjacencyList.size(); i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adjacencyList.get(i).size(); j++) {
				System.out.print(adjacencyList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
		// for a unweighted graph we can draw a path from both direction
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}

}
