package eshaan.learning.dsa.graph;

import java.util.List;

public class DetectCycleInUndirectedGraph {
    public static boolean isCyclicUndirectedGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {// Traverse each vertex, because the graph might be disconnected
            if (!visited[i]) {
                if (dfsCycleUndirected(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    // Traverse all the adjacent vertices
    private static boolean dfsCycleUndirected(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {// Traverse all the adjacent vertices
            if (!visited[neighbor]) {
                if (dfsCycleUndirected(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;// If an adjacent is visited and not parent, then there is a cycle
            }
        }
        return false;
    }
}
