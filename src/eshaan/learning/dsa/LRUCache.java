package eshaan.learning.dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    int val, key;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}
public class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        //defining dummy nodes to keep track of front and back
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;


    }

    public int get(int key) {
        //if the cache contins key

        if(!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int val) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, val);
        cache.put(key, newNode);
        add(newNode);

        if(cache.size()>capacity){
            //removing from front
            Node nodeToBeDeleted = head.next;
            cache.remove(nodeToBeDeleted.key);
            remove(nodeToBeDeleted);

        }

    }
    private void add(Node node){
        Node previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // Cache is {1=1}
        lruCache.put(2, 2); // Cache is {2=2, 1=1}
        System.out.println(lruCache.get(1)); // Returns 1, Cache is {1=1, 2=2}
        lruCache.put(3, 3); // Cache is {3=3, 1=1}, Evicts key 2
        System.out.println(lruCache.get(2)); // Returns -1 (not found)
        lruCache.put(4, 4); // Cache is {4=4, 3=3}, Evicts key 1
        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3, Cache is {3=3, 4=4}
        System.out.println(lruCache.get(4)); // Returns 4, Cache is {4=4, 3=3}
    }


}
