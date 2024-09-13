package eshaan.learning.dsa.graph;

import java.util.*;

public class GraphTraversalBFS {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    public void addEdge(int v, int w){
        //directed graph
        adjList.computeIfAbsent(v, k->new ArrayList<>()).add(w);
        //undirected graph
        //adjList.computeIfAbsent(w, k-> new ArrayList<>()).add(v);
    }
    public void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        bfsIterative(start, visited);
    }

    private void bfsIterative(int start, Set<Integer> visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int neighbor : adjList.getOrDefault(temp, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }

            }

        }
    }
}
