import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {

    int V;
    ArrayList<ArrayList<Integer>> arr;
    boolean[] visited;

    public DetectCycleInUndirectedGraph(int v) {
        V = v;
        arr = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[v];

        for (int i = 0; i < V; i++) {
            arr.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph graph = new DetectCycleInUndirectedGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 5);

        graph.CallDfsCycle(0);
    }

    private void CallDfsCycle(int s) {
        System.out.println(DfsCycle(s, -1));
        
        // disconnected graph
//        for (int i = 0; i < V; i++) {
//            if (visited[i] == false) {
//                if (DfsCycle(i, -1) == true) {
//                    return true;
//                }
//            }
//        }
//        
//        return false;
    }

    private boolean DfsCycle(int source, int parent) {
        visited[source] = true;

        for (int i = 0; i < arr.get(source).size(); i++) {
            int node = arr.get(source).get(i);

            if (visited[node] == false) {
                if (DfsCycle(node, source) == true) {
                    return true;
                }
            } else if (node != parent) {
                return true;
            }
        }

        return false;

    }

    private void addEdge(int s, int v) {
        arr.get(s).add(v);
        arr.get(v).add(s);
    }

}
