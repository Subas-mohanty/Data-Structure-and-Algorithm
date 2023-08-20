package Assignment._08_Strings._01_easy;

public class _02_String_shuffle {
    public static void main(String[] args) {
        int [] arr={4,5,6,7,0,2,1,3};
        String s="codeleet";
        String ans=restoreString(s,arr);
        System.out.println(ans);
    }
    static String restoreString(String s, int[] indices) {
        char [] ans= new char[s.length()];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            ans[indices[i]]=s.charAt(i);
        }
        sb.append(ans);
        return sb.toString();
    }
}
