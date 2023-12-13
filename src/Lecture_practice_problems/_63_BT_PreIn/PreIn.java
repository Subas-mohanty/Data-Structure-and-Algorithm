package Lecture_practice_problems._63_BT_PreIn;

import java.util.HashMap;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class PreIn {
    /*
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {

       // storing the inorder arrays value and index in a hashmap, when an element is present in the preorder array that means in the inorder array all the elements to its left will be on the left of the tree and all the element to its right will be on the right of the tree

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        int [] index={0};
        return helper(preOrder, inOrder,0, inOrder.length-1, map,index);
    }
    public TreeNode helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map,int [] index){
        if(left>right){
            return null;
        }
        int current=preOrder[index[0]];
        index[0]++;

        // index of the preorder array's element in the inorder array
        int inOrderIndex=map.get(current);
        TreeNode node=new TreeNode(current);

        // we are at the leaf node
        if (left == right) {
            return node;
        }
        node.left=helper(preOrder,inOrder,left,inOrderIndex-1,map,index);
        node.right=helper(preOrder,inOrder,inOrderIndex+1,right,map,index);

        return node;
    }

     */
}
