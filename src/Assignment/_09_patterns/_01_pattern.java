package Assignment._09_patterns;

public class _01_pattern {
    public static void main(String[] args) {
        pattern(4);

    }
    static void pattern(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("* ");
            }
            System.out.println(""); // new line
        }
    }
}
