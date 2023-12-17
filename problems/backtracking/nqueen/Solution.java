package problems.backtracking.nqueen;

public class Solution {

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int[][] board, int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 1)
                return false;
        }
        int xc = x, yc = y;
        while (xc >= 0 && yc >= 0) {
            if (board[xc][yc] == 1)
                return false;
            xc--;
            yc--;
        }
        xc = x;
        yc = y;
        while (xc < board.length && yc >= 0) {
            if (board[xc][yc] == 1)
                return false;
            xc++;
            yc--;
        }
        return true;
    }

    private static void nqueen(int[][] board, int n, int y) {
        if (n == 0) {
            printBoard(board);
            return;
        }
        for (int x = 0; x < board.length; x++) {
            if (isSafe(board, x, y)) {
                board[x][y] = 1;
                nqueen(board, n - 1, y + 1);
                board[x][y] = 0;
            }
        }
    }

    public static void nqueen(int boardSize) {
        int[][] board = new int[boardSize][boardSize];
        nqueen(board, boardSize, 0);
    }

    public static void main(String[] args) {
        nqueen(4);
    }
}
