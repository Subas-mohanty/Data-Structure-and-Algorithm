package Programming_Concepts;

import java.util.Arrays;

public class _06_Thread {

    public static void main(String[] args) {
        int[] g = {7, 8, 9, 10};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        // Arrays.sort(g);
        // Arrays.sort(s);

        // creating two different threads to do two different tasks
        Thread t1 = new Thread(()-> Arrays.sort(g));
        Thread t2 = new Thread(() -> Arrays.sort(s));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
