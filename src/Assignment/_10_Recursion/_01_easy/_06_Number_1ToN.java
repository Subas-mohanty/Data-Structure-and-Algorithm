package Assignment._10_Recursion._01_easy;

public class _06_Number_1ToN {
    public static void main(String[] args) {
        printNos(10);
    }
    static void printNos(int N) {
        if (N == 0) {
            return;
        }
        printNos(N-1);
        System.out.print(N + " ");
    }
}
