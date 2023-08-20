package Assignment._08_Strings._01_easy;

public class _01_defanging_IP_address {
    public static void main(String[] args) {
        String ans=defangIPaddr("a.b.c.d.e");
        System.out.println(ans);
    }
    static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
