package Programming_Concepts;

import java.util.Scanner;

public class _03_taking_big_inputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String [] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
