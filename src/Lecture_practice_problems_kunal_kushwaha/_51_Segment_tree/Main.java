package Lecture_practice_problems_kunal_kushwaha._51_Segment_tree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        tree.update(0,6); // updating index 0 from 3 to 6
//        tree.display();
        System.out.println(tree.query(0, 2));
    }
}
