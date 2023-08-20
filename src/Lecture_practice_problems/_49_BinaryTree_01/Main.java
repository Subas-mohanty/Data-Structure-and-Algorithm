package Lecture_practice_problems._49_BinaryTree_01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.prettyDisplay();
//        tree.display();
//        tree.preOrder();u
//        System.out.println();
//        tree.inOrder();
//        System.out.println();
//        tree.postOrder();

//        int [] nums={5,8,1,9,4,3};
        BST tree=new BST();
//        tree.populate(nums);
//        tree.display();
//        int [] nums={1,2,3,4,5,6};
//        BST tree=new BST();
//        tree.populateSorted(nums);
//        tree.display();
//        tree.preOrder();
//        System.out.println();
//        tree.postOrder();
//        System.out.println();
//        tree.inOrder();
        for (int i = 0; i < 33; i++) {
            tree.insert(i);
        }
        tree.display();
    }
}
