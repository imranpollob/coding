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

		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 1, 3);
		addEdge(adjacencyList, 2, 4);
		addEdge(adjacencyList, 2, 5);
		addEdge(adjacencyList, 3, 6);
		addEdge(adjacencyList, 3, 7);

		printGraph(adjacencyList);

		System.out.println("DFS: ");
		dfs(adjacencyList, 1);

	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int root) {
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[adjacencyList.size()];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}

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
		adjacencyList.get(source).add(destination);
	}

}
