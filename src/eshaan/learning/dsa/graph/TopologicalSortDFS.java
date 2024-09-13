package eshaan.learning.dsa.graph;

import java.util.*;

public class TopologicalSortDFS {
    public List<Integer> topoSortDFS(int v, List<List<Integer>>adj){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        //perfrom dfs on each vertex
        for(int i=0; i<v; i++){
            if(!visited.contains(v)){
                dfs(i, adj, visited, stack);
            }
        }
        //pop the stack
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;

    }
    private void dfs(int v, List<List<Integer>> adj, Set<Integer> visited, Stack<Integer> stack){
        //add the vertex to visited
        visited.add(v);
        stack.push(v);
        for(int neighbour : adj.get(v)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, adj, visited, stack);
            }
        }
        //push the current - parent vertex to stack - at the top
        stack.push(v);
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
