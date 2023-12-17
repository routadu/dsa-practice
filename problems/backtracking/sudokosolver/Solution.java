package problems.backtracking.sudokosolver;

public class Solution {

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(char[][] board, char key, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == key)
                return false;
            if (board[i][y] == key)
                return false;
        }
        int subBoardSize = (int) Math.sqrt(board.length);
        int subBoardX = x - x % subBoardSize;
        int subBoardY = y - y % subBoardSize;
        for (int i = subBoardX; i < subBoardX + subBoardSize; i++) {
            for (int j = subBoardY; j < subBoardY + subBoardSize; j++) {
                if (board[i][j] == key)
                    return false;
            }
        }
        return true;
    }

    private static void sudokoSolver(char[][] board, int subBoardSize, int x, int y) {
        if (x == board.length) {
            print(board);
            return;
        } else if (y == board.length)
            sudokoSolver(board, subBoardSize, x + 1, 0);
        else if (board[x][y] != '.')
            sudokoSolver(board, subBoardSize, x, y + 1);
        else {
            for (int i = 0; i < 9; i++) {
                if (isValid(board, (char) ('1' + i), x, y)) {
                    board[x][y] = (char) ('1' + i);
                    sudokoSolver(board, subBoardSize, x, y + 1);
                    board[x][y] = '.';
                }
            }
        }

    }

    public static void sudokoSolver(char[][] board) {
        sudokoSolver(board, (int) Math.sqrt(board.length), 0, 0);
    }

    public static void main(String[] args) {
        char[][] board = {
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '8', '.', '.', '.', '7', '.', '9', '.' },
                { '6', '.', '2', '.', '.', '.', '5', '.', '.' },
                { '.', '7', '.', '.', '6', '.', '.', '.', '.' },
                { '.', '.', '.', '9', '.', '1', '.', '.', '.' },
                { '.', '.', '.', '.', '2', '.', '.', '4', '.' },
                { '.', '.', '5', '.', '.', '.', '6', '.', '3' },
                { '.', '9', '.', '4', '.', '.', '.', '7', '.' },
                { '.', '.', '6', '.', '.', '.', '.', '.', '.' },
        };
        sudokoSolver(board);
    }
}
