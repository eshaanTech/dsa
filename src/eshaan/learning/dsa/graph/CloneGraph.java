package eshaan.learning.dsa.graph;

import java.util.*;

public class CloneGraph {
    Map<Node, Node> visitedNode = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        //coupy node
        if(node == null)
            return null;
        if(visitedNode.containsKey(node)){
            return visitedNode.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        visitedNode.put(node, newNode);
        //clone neighbours
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    public Node cloneBFS(Node node){
        Map<Node, Node>visitedMap = new HashMap<>();
        Queue<Node>queue = new LinkedList<>();
        queue.add(node);
        //clone the node
        while(!queue.isEmpty()){
            Node n = queue.poll();
            Node clonedNode = new Node(n.val, new ArrayList<>());
            visitedMap.put(node, clonedNode);
            for(Node neighbor: n.neighbors){
                if(!visitedMap.containsKey(neighbor)){
                    visitedMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                //add the cloned neighbour to the current node's clone neighbors list
                visitedMap.get(n).neighbors.add(visitedNode.get(neighbor));
            }

        }
        return visitedMap.get(node);
    }

}
