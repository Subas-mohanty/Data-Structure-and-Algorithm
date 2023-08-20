package Assignment._09_patterns;

public class _04_pattern {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        for (int row = 1; row <= n; row++) {
            // for the col
            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
