package Leetcode.Strings;

//https://leetcode.com/problems/move-pieces-to-obtain-a-string/?envType=daily-question&envId=2024-12-05
public class _2337_move_pieces_to_obtain_string {
    // TC : O(n)
    // SC : O(1)
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while(i < n || j < n){
            while(i < n && start.charAt(i) == '_') i++;
            while(j < n && target.charAt(j) == '_') j++;

            if(i == n || j == n) break;
            if(i < n && j < n){
                char ch = start.charAt(i);
                if(ch != target.charAt(j)) return false;
                if(ch == 'L' && i < j) return false;
                if(ch == 'R' && i > j) return false;
            }
            i++;
            j++;
        }
        return i == n && j == n;
    }
}
