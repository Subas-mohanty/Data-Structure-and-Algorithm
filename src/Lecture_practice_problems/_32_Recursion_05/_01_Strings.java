package Lecture_practice_problems._32_Recursion_05;

public class _01_Strings {
    public static void main(String[] args) {
//        String ans=removeLetter2("bacacdh");
//        System.out.println(ans);
//        String s="subasMohanty";
//        String ans=s.substring(1);
//        System.out.println(ans);
        System.out.println(removeApple("vbapplen"));
    }
    static void removeLetter(String empty, String main){
        if(main.isEmpty()){
            System.out.println(empty);
            return;
        }
        char ch=main.charAt(0);
        if(ch=='a'){
            removeLetter(empty,main.substring(1));
        } else{
            removeLetter(empty+ch,main.substring(1));
        }
    }


    static String removeLetter2(String main){
        if(main.isEmpty()){
            return "";
        }
        char ch=main.charAt(0);
        if(ch=='a'){
            return removeLetter2(main.substring(1));
        } else{
            return ch + removeLetter2(main.substring(1));
        }
    }

    static String removeApple(String main){
        if(main.isEmpty()){
            return "";
        }
        if(main.startsWith("apple")){
            return removeApple(main.substring(5));
        } else{
            return main.charAt(0) + removeApple(main.substring(1));
        }
    }


    static String removeAppNotApple(String main){
        if(main.isEmpty()){
            return "";
        }
        if(main.startsWith("app") && !main.startsWith("apple")){
            return removeAppNotApple(main.substring(5));
        } else{
            return main.charAt(0) + removeAppNotApple(main.substring(1));
        }
    }
}
