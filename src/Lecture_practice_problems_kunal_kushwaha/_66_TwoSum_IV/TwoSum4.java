package Lecture_practice_problems_kunal_kushwaha._66_TwoSum_IV;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSum4 {
    /*
    public boolean findTarget(TreeNode node, int k){
        // created a set and check whether target k-current node's value is present in the set or not, if not present add it to the set and call recursion for left and right
        Set<Integer> set = new HashSet<>();
        return helper(node, k, set);
    }
    private boolean helper(TreeNode node, int k, Set<Integer> set) {
        if(node == null){
            return false;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return helper(node.left,k,set) || helper(node.right,k,set);
    }

     */
}
