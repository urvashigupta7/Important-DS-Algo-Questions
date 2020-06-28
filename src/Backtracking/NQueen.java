package Backtracking;

public class NQueen {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        solve(board, 0);
    }

    public static void solve(boolean[][] board, int row) {
        if (row == 4) {
            printBoard(board);
            return;
        }
        for (int i = 0; i < board[row].length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = true;
                solve(board, row + 1);
                board[row][i] = false;
            }
        }
    }
    public static void printBoard(boolean [][]b){
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                if(b[i][j]){
                    System.out.print("X"+" ");
                }else{
                    System.out.print("-"+" ");
                }
            }
            System.out.println();
        }
        System.out.println("****************");
    }
    public static boolean isSafe(boolean [][]board,int row,int col){
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row,j=col;i>=0&&j<board[i].length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
}
