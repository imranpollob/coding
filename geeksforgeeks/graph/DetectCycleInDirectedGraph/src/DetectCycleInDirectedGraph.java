import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    int V;
    ArrayList<ArrayList<Integer>> arr;
    boolean[] visited;
    boolean[] record;

    public DetectCycleInDirectedGraph(int v) {
        V = v;
        arr = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[v];
        record = new boolean[v];

        for (int i = 0; i < V; i++) {
            arr.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
//        graph.addEdge(5, 3);

        graph.CallDfsCycle();
    }

    private void CallDfsCycle() {
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (DFSCycle(i) == true) {
                    System.out.println("Cycle Found");
                    return;
                }
            }
        }

        System.out.println("No Cycle Found");
    }

    private boolean DFSCycle(int source) {
        visited[source] = true;
        record[source] = true;

        for (int i : arr.get(source)) {
            if (visited[i] == false && DFSCycle(i) == true) {
                return true;
            } else if (record[i] == true) {
                return true;
            }
        }

        record[source] = false;

        return false;
    }

    private void addEdge(int s, int v) {
        arr.get(s).add(v);
    }

}
