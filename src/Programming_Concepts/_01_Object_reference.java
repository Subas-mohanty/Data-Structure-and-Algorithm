package Programming_Concepts;

import java.util.Arrays;

public class _01_Object_reference {
    public static void main(String[] args) {

        // primitives not change
        int a=3;
        int b=a;
        System.out.println();
        System.out.println(a);
        System.out.println(b);
        a=5;
        System.out.println(a);
        System.out.println(b);


        // strings also doesn't change
        String c="abc";
        String d=c;
        System.out.println();
        System.out.println(c);
        System.out.println(d);
        c="def";
        System.out.println(c);
        System.out.println(d);


        // objects like arrays are changed
        int [] arr={1,2,3,4,5};
        int [] num =arr;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(num));

        arr[0]=0;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(num));
    }
}
