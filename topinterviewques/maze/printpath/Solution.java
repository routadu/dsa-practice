package topinterviewques.maze.printpath;

public class Solution {

    private static void printWithDiagonalPath(int r, int c, int cr, int cc, String path) {
        if (cr == 1 && cc == 1) {
            System.out.println(path + "End");
        }
        if (cr > 1)
            printWithDiagonalPath(r, c, cr - 1, cc, path + "V->");
        if (cc > 1)
            printWithDiagonalPath(r, c, cr, cc - 1, path + "H->");
        if (cr > 1 && cc > 1)
            printWithDiagonalPath(r, c, cr - 1, cc - 1, path + "D->");
    }

    private static void printPath(int r, int c, int cr, int cc, String path) {
        if (cr == 1 && cc == 1) {
            System.out.println(path + "End");
        }
        if (cr > 1)
            printPath(r, c, cr - 1, cc, path + "V->");
        if (cc > 1)
            printPath(r, c, cr, cc - 1, path + "H->");
    }

    public static void printPath(int r, int c) {
        printPath(r, c, r, c, "");
    }

    public static void printWithDiagonalPath(int r, int c) {
        printWithDiagonalPath(r, c, r, c, "");
    }

    public static void main(String[] args) {
        printWithDiagonalPath(3, 3);
    }
}
