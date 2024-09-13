package eshaan.learning.dsa.graph;
import java.util.*;

public class TopologicalSortBFS {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    public void addEdge(int v, int w){
        //directed graph
        adjList.computeIfAbsent(v, k->new ArrayList<>()).add(w);
        //undirected graph
        //adjList.computeIfAbsent(w, k-> new ArrayList<>()).add(v);
    }
    public List<Integer> topoSortBFS(int v, List<List<Integer>> adj){
        int[] inDegree = calculateInDegree(v, adj);
        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            topoOrder.add(current);
            for(int neighbor : adj.get(current)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    queue.add(neighbor);
            }
        }
        if(topoOrder.size()!=v) {
            throw new IllegalArgumentException("the graph has cycle");
        }
        return topoOrder;

    }
    private int[] calculateInDegree(int v, List<List<Integer>> adj){
        int[] inDegree = new int[v];
        for(int i = 0; i<v; i++){
            for(int neigbor : adj.get(i)){
                //add 1 to the neigbor's inDegree count
                inDegree[neigbor]++;
            }
        }
        return inDegree;
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        // Graph edges
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        TopologicalSortDFS ts = new TopologicalSortDFS();
        List<Integer> result = ts.topoSortDFS(vertices, adjList);
        System.out.println("Topological Sort using DFS: " + result);
    }
}
