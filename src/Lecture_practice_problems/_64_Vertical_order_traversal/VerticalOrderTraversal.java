package Lecture_practice_problems._64_Vertical_order_traversal;

import Lecture_practice_problems._49_BinaryTree_01.BinaryTree;
import Lecture_practice_problems._49_BinaryTree_01.BinaryTree.Node;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate(new Scanner(System.in));
        BinaryTree.Node root=tree.getRoot();
        List<List<Integer>> ans= tree.verticalTraversal(root);
        tree.verticalTraversal(root);
        for(List<Integer> list: ans){
            System.out.print(list);
        }
    }
    public static List<List<Integer>> verticalTraversal(Node node) {
        List<List<Integer>> ans= new ArrayList<>();
        if(node == null){
            return ans;
        }
        int col=0;
        Queue<Map.Entry<Node, Integer>> queue = new ArrayDeque<>();
        HashMap<Integer, ArrayList<Integer> > map = new HashMap<>();


        queue.offer(new AbstractMap.SimpleEntry<>(node, col));
        int min=0;
        int max=0;

        while(!queue.isEmpty()){
            Map.Entry<Node, Integer> removed=queue.poll();
            node = removed.getKey();
            col= removed.getValue();

            if(node != null){
                if(!map.containsKey(col)){
                    map.put(col, new ArrayList<Integer>());
                }
                map.get(col).add(node.value);
                min = Math.min(min,col);
                max= Math.max(max,col);

            }
            if(node.left!=null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1 ));
            }
            if(node.right!=null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1 ));
            }

        }
        for(int i = min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}
