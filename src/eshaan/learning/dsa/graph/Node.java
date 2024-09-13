package eshaan.learning.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> neighbors) {
        val = val;
        neighbors = neighbors;
    }
}
