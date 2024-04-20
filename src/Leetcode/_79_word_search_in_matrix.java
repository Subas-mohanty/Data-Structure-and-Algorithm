package Leetcode;
//https://leetcode.com/problems/word-search/?envType=daily-question&envId=2024-04-03
public class _79_word_search_in_matrix {
    public static void main(String[] args) {
        char [][] board = {
                {'a','b','c','e'}
                ,{'s', 'f', 'c', 's'}
                ,{'a', 'd', 'e', 'e' }
        };
        String word = "abcced";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int ind = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(ind)) {
                   boolean ans =  findWord(word, i, j, board, ind);
                   if(ans) return true;
                }
            }
        }
        return false;
    }

    public static boolean findWord(String word, int i, int j, char[][] board, int ind) {
        if (ind == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(ind)) {
            return false;
        }
//        if(board[i][j] == word.charAt(ind)) return true;

//        char orgChar = board[i][j];
//        if(orgChar == '*') return false;

        board[i][j] = '*';

        boolean left = findWord(word, i, j-1, board, ind+1);
        boolean right = findWord(word, i, j+1, board, ind+1);
        boolean up = findWord(word, i-1, j, board, ind+1);
        boolean down = findWord(word, i+1, j, board, ind+1);

//        board[i][j] = orgChar;
        board[i][j] = word.charAt(ind);
        return left || right || up || down;
    }
    public static boolean findWord2(String word, int i, int j, char[][] board, int ind) {
        if (ind == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(ind)) {
            return false;
        }
        // Mark the current cell as visited
        board[i][j] = '*';

        int[] r = { -1, 1, 0, 0 };
        int[] c = { 0, 0, -1, 1 };

        // Recursively search in all four directions from the current cell
        for (int k = 0; k < c.length; k++) {
            boolean ans = findWord2( word, i + r[k], j + c[k], board, ind + 1);
            if (ans) {
                return ans; // If the word is found, return true
            }
        }

        board[i][j] = word.charAt(ind);
        return false;
    }
}
