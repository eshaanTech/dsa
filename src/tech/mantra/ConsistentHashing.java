package tech.mantra;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConsistentHashing {

    private final int numberOfReplicas;
    private final SortedMap<Integer, String> circle = new TreeMap<>();

    public ConsistentHashing(int numberOfReplicas, Collection<String> nodes) {
        this.numberOfReplicas = numberOfReplicas;

        for (String node : nodes) {
            add(node);
        }
    }

    public void add(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hash(node + i), node);
        }
    }

    public void remove(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hash(node + i));
        }
    }

    public String get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int hash(Object key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(key.toString().getBytes(StandardCharsets.UTF_8));
            return ((bytes[3] & 0xFF) << 24) | ((bytes[2] & 0xFF) << 16) |
                    ((bytes[1] & 0xFF) << 8) | (bytes[0] & 0xFF);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("Node1", "Node2", "Node3");
        ConsistentHashing consistentHashing = new ConsistentHashing(3, nodes);

        // Testing key distribution
        String[] keys = {"Key1", "Key2", "Key3", "Key4"};
        for (String key : keys) {
            System.out.println(key + " is mapped to " + consistentHashing.get(key));
        }

        // Adding a new node
        consistentHashing.add("Node4");
        System.out.println("After adding Node4:");
        for (String key : keys) {
            System.out.println(key + " is mapped to " + consistentHashing.get(key));
        }

        // Removing a node
        consistentHashing.remove("Node2");
        System.out.println("After removing Node2:");
        for (String key : keys) {
            System.out.println(key + " is mapped to " + consistentHashing.get(key));
        }
    }
}
