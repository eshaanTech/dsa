package eshaan.learning.dsa.graph;

import java.util.*;

public class GraphDFSRecursive {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    public void addEdge(int v, int w){
        //directed graph
        adjList.computeIfAbsent(v, k->new ArrayList<>()).add(w);
        //undirected graph
        //adjList.computeIfAbsent(w, k-> new ArrayList<>()).add(v);
    }
    public void dfs(int start){
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int start, Set<Integer>visited){
        //visit the node
        visited.add(start);
        //recursivly visit the neighbours
        for(int neighbour : adjList.getOrDefault(start, new ArrayList<>())){
            if(!visited.contains(neighbour))
                dfsRecursive(neighbour, visited);
        }
    }

    private void dfsIterative(int start, Set<Integer> visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited.add(start);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int neighbor : adjList.getOrDefault(temp, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    stack.push(neighbor);
                }

            }

        }


    }
}
