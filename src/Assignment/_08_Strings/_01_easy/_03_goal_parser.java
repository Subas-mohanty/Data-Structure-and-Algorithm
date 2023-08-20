package Assignment._08_Strings._01_easy;

public class _03_goal_parser {
    public static void main(String[] args) {
        String ans=interpret("G()()()()(al)");
        System.out.println(ans);
    }
    static String interpret(String command) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i)=='G'){
                sb.append("G");
            }else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                sb.append("o");
            }else if(command.charAt(i)=='(' && command.charAt(i+1)=='a'){
                sb.append("al");
            }
        }
        return sb.toString();
    }
}
