package Lecture_practice_problems._50_AVL_Trees;

public class main {
    public static void main(String[] args) {
        AVL tree = new AVL();
//        for (int i = 0; i < 23; i++) {
//            tree.insert(i);
//        }
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(16);
        tree.insert(15);
        tree.display();
    }
}
