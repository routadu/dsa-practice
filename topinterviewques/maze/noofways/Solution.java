package topinterviewques.maze.noofways;

import java.util.HashMap;

public class Solution {

    private static HashMap<String, Integer> hmp;

    private static int noOfWaysWithDiagonal(int r, int c, int cr, int cc) {
        if (cr == 1 || cc == 1) {
            return 1;
        }
        return noOfWaysWithDiagonal(r, c, cr - 1, cc) + noOfWaysWithDiagonal(r, c, cr, cc - 1) +
                cr > 1 && cc > 1 ? noOfWaysWithDiagonal(r, c, cr - 1, cc - 1) : 0;
    }

    private static int noOfWays(int r, int c, int cr, int cc) {
        if (cr == 1 || cc == 1) {
            return 1;
        }
        return noOfWays(r, c, cr - 1, cc) + noOfWays(r, c, cr, cc - 1);
    }

    private static int noOfWaysDP(int r, int c, int cr, int cc) {
        String k = cr + "," + cc;
        if (hmp.containsKey(k))
            return hmp.get(k);
        if (cr == 1 || cc == 1) {
            return 1;
        }
        int val = noOfWays(r, c, cr - 1, cc) + noOfWays(r, c, cr, cc - 1);
        hmp.put(k, val);
        return val;
    }

    public static int noOfWays(int r, int c) {
        return noOfWays(r, c, r, c);
    }

    public static int noOfWaysDP(int r, int c) {
        hmp = new HashMap<>();
        return noOfWaysDP(r, c, r, c);
    }

    public static int noOfWaysWithDiagonal(int r, int c) {
        return noOfWaysWithDiagonal(r, c, r, c);
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysWithDiagonal(3, 3));
    }
}
