package Lecture_practice_problems._38_OOPS_02_Packages_static;

public class Singleton {
    private Singleton () {
    }

    // we are only defining the object here not initializing/creating it, we are doing that inside the getInstance function
    private static Singleton instance;

    public static Singleton getInstance() {
        // check whether 1 obj only is created or not, if not then create and return the object otherwise return the existing object
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}