package eshaan.learning.dsa.binaryTree;

import java.util.*;

/*
Approach:
    Create a Column Table: Use TreeMap to keep the columns (horizontal distances) sorted. Each entry in the tree map represents a column of the tree
    BFS Traversal: Use queue to perfrom BFS. Each entry in the queue contains the current node, its horizontal distance from the root and its level
    Sorting: Once all nodes are processed, sort the nodes in each column, first by their level and by their value of they are in same level
    Result Construction: extract the sorted list value from each column and add them to result list
 */
class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null){
            return output;
        }
        //create a TreeMap to store column data (horizontal distance)
        Map<Integer, List<Pair<Integer, Integer>>>columnTable = new TreeMap();
        //create a queue for Breadth First Search (BFS) traversal
        Queue<Pair<TreeNode, Pair<Integer, Integer>>>queue= new LinkedList<>();
        // (node, (horizontal distance, level))
        //int minColumn=0, maxColumn=0;
        if(root!=null){
            queue.add(new Pair<>(root, new Pair<>(0, 0)));
        }
        while(!queue.isEmpty()){
            Pair<TreeNode, Pair<Integer, Integer>> p = queue.poll();
            TreeNode node = p.getKey();
            int horizontalDistance = p.getValue().getKey();
            int level = p.getValue().getValue();
            //minColumn = Integer.min(minColumn, horizontalDistance);
            //maxColumn = Integer.max(maxColumn, horizontalDistance);
            //add the node to column table
            columnTable.putIfAbsent(horizontalDistance, new ArrayList<>());
            columnTable.get(horizontalDistance).add(new Pair<>(level, node.val));
            if(node.left!=null){
                queue.add(new Pair<>(node.left, new Pair<>(horizontalDistance+1, level+1)));
            }
            if(node.right!=null){
                queue.add(new Pair<>(node.right, new Pair<>(horizontalDistance+1, level+1)));
            }

        }
        // Prepare the result list
        for (List<Pair<Integer, Integer>> entries : columnTable.values()) {
            // Sort by level first and then by value
            Collections.sort(entries, (a, b) -> {
                if (a.getKey().equals(b.getKey())) {
                    return a.getValue() - b.getValue();
                } else {
                    return a.getKey() - b.getKey();
                }
            });

            List<Integer> column = new ArrayList<>();
            for (Pair<Integer, Integer> pair : entries) {
                column.add(pair.getValue());
            }
            output.add(column);
        }

        return output;
    }
}
