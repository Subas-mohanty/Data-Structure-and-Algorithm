package Programming_Concepts;

public class _08_mutable_immutable {
    public static void main(String[] args) {
        int n = 2147483647;
        String s = "subas";
        String t = "Subas";
        String st = s + " mohanty";

        // because of the same data, they have same memory address, because they point to only a single address
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(t));

        // when the string changes the address also changes, because a new String object is being created and now this points to the newly created address
        System.out.println(System.identityHashCode(st));
    }
}
