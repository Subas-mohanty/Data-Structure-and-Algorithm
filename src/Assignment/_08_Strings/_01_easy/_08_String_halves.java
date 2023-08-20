package Assignment._08_Strings._01_easy;

public class _08_String_halves {
    public static void main(String[] args) {
        boolean ans=halvesAreAlike("textbook");
        System.out.println(ans);
    }
    static boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        String first=s.substring(0,s.length()/2);
        String second=s.substring(s.length()/2,s.length());
        int firstCount=0;
        int secondCount=0;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)=='a' || first.charAt(i)=='e' || first.charAt(i)=='i' || first.charAt(i)=='o' || first.charAt(i)=='u'){
                firstCount++;
            }
        }
        for (int i = 0; i < second.length(); i++) {
            if(second.charAt(i)=='a' || second.charAt(i)=='e' || second.charAt(i)=='i' || second.charAt(i)=='o' || second.charAt(i)=='u'){
                secondCount++;
            }
        }
        if(firstCount==secondCount){
            return true;
        }
        return false;
    }
}
