import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class TopologicalSort {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        System.out.println("Topological Sort: ");
        topologicalSort(adj, V);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int in_degree[] = new int[V];

        for (int i = 0; i < in_degree.length; i++) {
            in_degree[i] = 0;
        }

        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                in_degree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int item = queue.poll();
            System.out.print(item + " ");

            for (int i = 0; i < adj.get(item).size(); i++) {
                int node = adj.get(item).get(i);

                in_degree[node]--;

                if (in_degree[node] == 0) {
                    queue.add(node);
                }
            }

        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

}
