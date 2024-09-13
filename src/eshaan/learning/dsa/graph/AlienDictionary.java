package eshaan.learning.dsa.graph;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        //Step-1: create a graph
        Map<Character, List<Character>> graph = buildGraph(words);
        if(graph==null){
            return ""; //cycle detected
        }
        //STEP-2: Perform DFS to detect cycles and get the topological sort
        Stack<Character> resultStack = performTopologicalSort(graph);
        if(resultStack==null){
            return "";
        }
        //Step-3: Construct and returend results
        return buildResult(resultStack);


    }
    //construc string from topologically sorted stack
    private String buildResult(Stack<Character> resultStack){
        StringBuilder sb = new StringBuilder();
        while(!resultStack.isEmpty()){
            sb.append(resultStack.pop());
        }
        return sb.toString();
    }

    //perform topological sort
    private Stack<Character> performTopologicalSort(Map<Character, List<Character>> graph){
        //Map to track visited nodes
        Map<Character, Boolean>visited = new HashMap<>();
        //Map to track nodes in the DFS Call Stack (Current Path) to detect cycles
        Map<Character, Boolean>onCallStack = new HashMap<>();
        //Stack to store the topoligical order
        Stack<Character>resultStack = new Stack<>();
        //perfomr DFS on each node
        for(char node : graph.keySet()){
            if(!visited.containsKey(node)){
                boolean hasCycle = dfs(node, graph, visited, onCallStack, resultStack);
                if(hasCycle)
                    return null;
            }
        }
        return resultStack;

    }
    //DFS to detect cycle and build topoligical order
    private boolean dfs(char node, Map<Character, List<Character>> graph, Map<Character, Boolean>visited, Map<Character, Boolean> onCallStack, Stack<Character> resultStack){
        //mark the node visited
        visited.put(node, true);
        //mark the node is in current call stack
        onCallStack.put(node, true);
        for(char neighbor: graph.get(node)){
            //check whethen the neigbor is in the call stack
            if(onCallStack.getOrDefault(neighbor, false)){
                //cycle detected
                return true;
            }
            //if the neighbor is not yet visited
            if(!visited.containsKey(neighbor)){
                boolean hasCycle = dfs(neighbor, graph, visited, onCallStack, resultStack);
                if(hasCycle)
                    return true;
            }
        }
        //remove the node from the current DFS call stack
        onCallStack.put(node, false);
        //add the node to topoligical order stack
        resultStack.push(node);
        return false;
    }
    //build the graph based on the given words
    private Map<Character, List<Character>>buildGraph(String[] words){
        Map<Character, List<Character>> graph = new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }
        //STEP-2: build the graph by comparing adjecent words
        for(int i=0; i< words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            //check for invalid case
            if(first.length()>second.length() && first.startsWith(second))
                return null;
            //compare chars of word[i] with chars word[i+1]; if the chars dont match, add to adj
            for(int j=0; j<Math.min(first.length(), second.length()); j++){
                char from=first.charAt(j);
                char to=second.charAt(j);
                if(from!=to){
                    graph.get(from).add(to);
                    break;
                }

            }
        }
        return graph;

    }
    public static void main(String[] args){
        String[] words = new String[]{"wrt","wrf","er","ett","rftt"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(words));
    }



}
