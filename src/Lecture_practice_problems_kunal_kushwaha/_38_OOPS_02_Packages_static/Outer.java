package Lecture_practice_problems_kunal_kushwaha._38_OOPS_02_Packages_static;

public class Outer {
    // The Outer class can't be static because it itself doesn't depend on any other class, it is independent and it doesn't need any other classes instances. So it can't be static
    static class Inner{
        String name;
        int rollNo;

        public Inner(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // this can't be done if we don't make Inner as static because the Inner class needs an instance of Outer class and in main it doesn't have one, so it will give an error

        Inner a = new Inner("subas");
        Inner b=new Inner("subu");
        // This will create two distinct objects and changing one , will not change another. Because static doesn't mean we can't create individual objects , it means it doesn't depend on the Outer classes instance

        // This will print subas and subu
        System.out.println(a.name);
        System.out.println(b.name);

    }
}
