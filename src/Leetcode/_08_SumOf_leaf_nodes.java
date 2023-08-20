package Leetcode;
import Lecture_practice_problems._49_BinaryTree_01.BinaryTree;
import Lecture_practice_problems._49_BinaryTree_01.BinaryTree.Node;

import java.util.Scanner;

public class _08_SumOf_leaf_nodes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        tree.populate(scanner);
        tree.display();
        int sum=sumOfLeftLeaves(tree.root);
        System.out.println(sum);
    }
    static public int sumOfLeftLeaves(Node root) {
        return sum(root,0);
    }
    static public int sum(Node root,int sum){
        if(root==null){
            return 0;
        }
        sum(root.left,sum);
        sum+=root.value;
        sum(root.right,sum);

        return sum;
    }
}
