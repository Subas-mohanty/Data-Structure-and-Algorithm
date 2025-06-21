package Low_Level_Design;

import static java.lang.Math.abs;
//https://www.youtube.com/watch?v=gktZsX9Z8Kw&list=PLMCXHnjXnTnvQVh7WsgZ8SurU1O2v_UM7&index=1
// Design a tic tac toe game system
// there will be a 3*3 board, two users can play the game, one will put 'X' and other one will put 'O' alternatively, consider the winning condition and valid moves
public class Tic_Tac_Toe {
    int n;
    int winner = 0;
    private final int [][] board;
    public Tic_Tac_Toe(int n){
        this.board = new int[n][n];
        this.n = n;
    }
//    private final Statistics; // will store user statistics, eg : how many games he has played, wins/lose etc

    /*
        @param player : 1 or -1, 1 means player 1 and -1 means player 2
        @param row : row index where the value will be put
        @param col : col index where the value will be put
        return 0 if player 1 win or -1 if player 2 win and 0 if the game is a draw
     */

    public int move(int row, int col, int player){
        // check for illegal moves
        if(row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("invalid move");
        }
        if(player != -1 && player != 1){
            throw new IllegalArgumentException("invalid player id");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("invalid move"); // someone previously marked that cell
        }

        // make a move
        board[row][col] = player;

        // check for winner, if after this move any row or any col or diagonal have all values equal to same, then this player won, because he is the one who made the move

//        int winner = checkWinner(board, row, col, player);

        int [] rowSum = new int[n];
        int [] colSum = new int[n];
        int diagSum = 0;
        int revDiagSum = 0;
        colSum[col] += player;
        rowSum[row] += player;

        if(row == col) diagSum += player;
        if(row == n - 1 - col) revDiagSum += player;

        if(abs(rowSum[row]) == n || abs(colSum[col]) == n || abs(diagSum) == n || abs(revDiagSum) == n) winner = player; // if sum of row or col == n, then current player is the winner, as the values we are adding is 1 and -1, the sum will be 3 and -3 if any player won
        return getWinner();
    }


    private int getWinner(){
        return winner;
    }
    private int checkWinner(int [][] board, int row, int col, int player){
        // check row
        boolean rowval = true;
        for(int i = 0; i < n; i++){
            if(board[row][col] != player) rowval = false;
        }

        boolean colval = true;
        for(int i = 0; i < n; i++){
            if(board[i][col] != player) colval = false;
        }

        // check diagonal
        // check this only if (row == col)
        boolean diagvalue = true;
        for(int i = 0; i < n; i++){
            if(board[i][i] != player) diagvalue = false;
        }

        // check reverse diagonal
        // check this only if (row == n - 1 - col)
        boolean diagrevval = true;
        for(int i = 0; i < n; i++){
            if(board[i][n - i - 1] != player) diagrevval = false;
        }
        if(rowval || colval || diagrevval || diagvalue) return player;

        return 0;
    }
}
