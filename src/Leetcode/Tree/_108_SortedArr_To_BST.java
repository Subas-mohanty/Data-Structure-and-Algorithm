package Leetcode.Tree;

import Leetcode.TreeNode;

public class _108_SortedArr_To_BST{

    public TreeNode sortedArrayToBST(int[] nums) {
        return populate(nums,0,nums.length);
    }
    public TreeNode populate(int[] nums, int start, int end) {
        if(start>=end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode (nums[mid]);
        node.left=populate(nums,start,mid);
        node.right= populate(nums,mid+1,end);
        return node;
    }

}
