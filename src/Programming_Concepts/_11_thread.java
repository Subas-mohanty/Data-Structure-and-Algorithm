package Programming_Concepts;

public class _11_thread {
    public static void main(String[] args) {
//        Runnable infiniteTask = () -> {
//            int a = 0;
//            while (true) {
//                a++;
//            }
//        };
//
        for (int i = 0; i < 20; i++) {
            String name = "thread" + i;
            Thread thread = new Thread(_11_thread::help);
            thread.start();

        }

    }
    public static void help(){
        int a = 0;
        while(true){
            a++;
        }
    }
}
