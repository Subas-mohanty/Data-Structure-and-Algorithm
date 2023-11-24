package Leetcode;

import Lecture_practice_problems._49_BinaryTree_01.BST;
import Lecture_practice_problems._49_BinaryTree_01.BST.Node;

public class _26_SortedArr_To_BST{

    public Node sortedArrayToBST(int[] nums) {
        return populate(nums,0,nums.length);
    }
    public Node populate(int[] nums, int start, int end) {
        if(start>=end){
            return null;
        }
        int mid=start+(end-start)/2;
//        Node node=new Node (nums[mid]);
//        node.left=populate(nums,start,mid);
//        node.right= populate(nums,mid+1,end);
//        return node;
        return null; // comment when you ran the code
    }

}
