package Lecture_practice_problems_kunal_kushwaha._61_HuffmanCoder;

import javax.management.ConstructorParameters;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// SC : O(N)
// TC : O(NlogN)

public class HuffmanCoder {
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    public class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    // constructor
    public HuffmanCoder(String feeder) throws Exception {
        // creating a frequency map
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cChar = feeder.charAt(i);
            if (fmap.containsKey(cChar)) {
                int value = fmap.get(cChar); // get the value than increase it by 1 then put it back
                value++;
                fmap.put(cChar, value);
            }
            fmap.put(cChar, 1);
        }

        // created a heap
        Heap<Node> minHeap = new Heap<>();
        // provides the set view of the map elements
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        // for every element in the map, created a node and then add the node into the minheap
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.insert(newNode);
        }
        Node rootNode = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(rootNode, "");
    }

    // creating the encoder and decoder hashmap
    private void initEncoderDecoder(Node node, String opSoFar) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, opSoFar);
            this.decoder.put(opSoFar, node.data);
        }
        initEncoderDecoder(node.left, opSoFar + "0"); // when we go left we add 0
        initEncoderDecoder(node.right, opSoFar + "1"); // when we go right we add 1
    }

    public String encode(String source) {
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans += encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString) {
        String key="";
        String ans="";
        for (int i = 0; i < codedString.length(); i++) {
            key=key+codedString.charAt(i); // key is for , if an single character doesn't represent any value than we have to add the next 0/1 to check further , look at DSA-01 dt: 02-12-2023
            if (decoder.containsKey(key)) {
                ans+=decoder.get(key);
                key="";
            }
        }
        return ans;
    }
}
