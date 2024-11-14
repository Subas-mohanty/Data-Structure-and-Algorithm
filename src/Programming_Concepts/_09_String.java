package Programming_Concepts;

public class _09_String {
    public static void main(String[] args) {
        char [] ch = {'s', 'u', 'b', 'a', 's'};
        byte [] arr = {65, 65, 67, 65};

//        String name = new String(ch);
//        System.out.println(name); // print subas
//        System.out.println(new String(arr)); // print AACA, treat array element as ascii value


        // string pool
        String st = "java";
        String str = "java"; // these will have same address as st, because the strings are same so java will point str to "java", which is already there in the string pool
        // but if we create a string object like this, then they will have different address
        String strr = new String("java"); // this will have different address then st and str


//        String s = new String("name");
        String s = "subas";
        System.out.println(s);
        s = "ask";
        System.out.println(s);

    }
}
