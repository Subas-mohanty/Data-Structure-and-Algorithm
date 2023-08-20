package Assignment._09_patterns;

public class _02_pattern {
    public static void main(String[] args) {
        pattern(4);
    }
    static void pattern(int n){
        for (int row = 1; row <= n; row++) {
            // for every row , print the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed , we need to add a new line
            System.out.println("");
        }
    }
}
