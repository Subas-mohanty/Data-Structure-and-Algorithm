package Low_Level_Design;

import java.util.HashMap;
import java.util.Map;

// design a cache, which store key,value pairs
// key -> string, value -> string
// maintain capacity of the cache, when the cache is full remove the least recently use key and value pair, and insert the new one
// using doubly linked list to keep track of the least recently used key,value pair
public class Cache {
    private final int capacity;
    private final Map<String, Node> map;
    private final DLL dll;

    public Cache(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DLL();
    }

    public void add(String key, String val){
        if(key == null || val == null) throw new IllegalArgumentException("key and value can't be empty");

        if(map.containsKey(key)){
            Node recent = map.get(key);
            recent.val = val; // if key is already present just update the value
            dll.keyAccessed(recent);
        }
        else if(capacity == map.size()){
            Node leastRecentlyUsed =  dll.removeNode();
            map.remove(leastRecentlyUsed.key);
        }
        Node node = new Node(key, val);
        map.put(key, node);
        dll.keyAccessed(node);
    }

    public String get(String key){
        if(!map.containsKey(key)) return null;
        Node node = map.get(key);
        dll.keyAccessed(node);
        return node.val;
    }


    private static class DLL{
        Node head;
        Node tail;

        public DLL(){
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.prev = head;
        }
        public Node removeNode(){
            if (head.next == tail) throw new IllegalStateException("Cache is empty");
            Node lruNode = head.next;
            detachNode(lruNode);
            return lruNode;
        }

        public void keyAccessed(Node node){
            this.detachNode(node);
            this.attachAtEnd(node);
        }

        private void detachNode(Node node){
            if(node == null) return;

            // prev --> Node --> next
            //      <--      <--
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void attachAtEnd(Node node){
            Node lastNode = tail.prev;
            lastNode.next = node;
            node.prev = lastNode;
            node.next = tail;
            tail.prev = node;
        }
    }
    private static class Node{
        String key;
        String val;
        Node prev;
        Node next;

        public Node(String key, String val){
            this.key = key;
            this.val = val;
        }
    }
}

