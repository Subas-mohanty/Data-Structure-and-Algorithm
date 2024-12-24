package Lecture_practice_problems_kunal_kushwaha._21_String;

public class _03_performance {
    public static void main(String[] args) {
        String series="";
        for (int i = 0; i <26; i++) {
            char ch=(char)('a'+i);
            series=series+ch;
        }
        System.out.println(series);
    }
}
