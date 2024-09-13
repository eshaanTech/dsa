package eshaan.learning.dsa.list;

import java.util.HashMap;
import java.util.Map;
class ListNodeWithRandom {
    int val;
    ListNodeWithRandom next;
    ListNodeWithRandom random;

    public ListNodeWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyLIstWIthRandomPointer {
    Map<ListNodeWithRandom, ListNodeWithRandom> visited = new HashMap<>();
    public ListNodeWithRandom copyRandomList(ListNodeWithRandom head) {
        //base case
        if(head==null){
            return null;
        }
        //check if the node is already processed
        if(visited.containsKey(head)){
            return visited.get(head);
        }
        //clone the head
        ListNodeWithRandom node = new ListNodeWithRandom(head.val);
        //add the node to visited
        visited.put(head, node);
        //clone node.next
        node.next = copyRandomList(head.next);
        //clone random node
        node.random = copyRandomList(head.random);
        return node;
    }
}
