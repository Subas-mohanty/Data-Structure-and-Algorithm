package Lecture_practice_problems._50_AVL_Trees;

public class main {
    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 23; i++) {
            tree.insert(i);
        }
        tree.prettyDisplay();
    }
}
