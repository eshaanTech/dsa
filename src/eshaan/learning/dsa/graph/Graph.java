package eshaan.learning.dsa.graph;

import java.util.*;

public class Graph {
    Map<Integer, List> adjVertices = new HashMap<>();
    public Graph(){
        this.adjVertices = new HashMap<>();
    }
    public void addVertex(int vertex){
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int v1, int v2){
        if(adjVertices.containsKey(v1)){
            adjVertices.get(v1).add(v2);//for directed graph
            //adjVertices.get(v2).add(v1); for undirected graph
        }
    }

    public void removeEdge(int v1, int v2){
        //for directed
        if(adjVertices.containsKey(v1)){
            adjVertices.get(v1).remove(v2);
        }
        /*
        for undirected graph
        if(adjVertices.containsKey(v2)){
            adjVertices.get(v2).remove(v1);
        }
        */

    }
    public void removeVertex(int vertex){
        if(adjVertices.containsKey(vertex)){
            adjVertices.remove(vertex);
        }
    }

    public List<Integer> getAdjVerticies(int vertex){
        return adjVertices.get(vertex);
    }

    public void dfs(int vertex){
        Stack<Integer>stack = new Stack<>();
        Set<Integer>visited = new HashSet<>();
        stack.push(vertex);
        while(!stack.isEmpty()){
            int tempVertex = stack.pop();
            List<Integer>adjList = adjVertices.get(tempVertex);
            for(int v : adjList){
                if(!visited.contains(v)){
                    stack.push(v);
                    visited.add(v);
                }

            }

        }
    }

    public void bfs(int startVertex){
        Queue<Integer>queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startVertex);
        visited.add(startVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            List<Integer>adjList = adjVertices.get(currentVertex);
            for(int v : adjList){
                if(!visited.contains(v)){
                    queue.add(v);
                    visited.add(v);
                }


            }
        }
    }







}
