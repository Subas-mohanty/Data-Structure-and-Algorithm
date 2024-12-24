package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// DSA-01 Dt:26-11-2023
public class _04_BT_zigzag_level_traversal {
    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse= false;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> cLevel = new LinkedList<>();
            for(int i=0;i<levelSize;i++){
                if(!reverse){
                    TreeNode cNode = deque.pollFirst();
                    cLevel.add(cNode.val);
                    if(cNode.left!=null){
                        deque.offerLast(cNode.left);
                    }
                    if(cNode.right!=null){
                        deque.offerLast(cNode.right);
                    }
                }
                else{
                    TreeNode cNode = deque.pollLast();
                    cLevel.add(cNode.val);
                    if(cNode.right!=null){
                        deque.offerFirst(cNode.right);
                    }
                    if(cNode.left!=null){
                        deque.offerFirst(cNode.left);
                    }
                }
            }
            reverse=!reverse;
            list.add(cLevel);
        }
        return list;
    }
     */
}
