package problems.recursion.noofwaysinmatrix;

public class Solution {

    public static int noOfWays(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return noOfWays(m - 1, n) + noOfWays(m, n - 1);
    }

    public static void main(String[] args) {
        int result = noOfWays(4, 5);
        System.out.println("No of ways: " + result);
    }
}
