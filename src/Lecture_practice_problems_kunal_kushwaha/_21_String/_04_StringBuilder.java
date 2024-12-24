package Lecture_practice_problems_kunal_kushwaha._21_String;
// String is immutable but StringBuilder is mutable it means it does not create object everytime the for loop is running
public class _04_StringBuilder {
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <26; i++) {
            char ch=(char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder);
    }
}
