package problems.recursion.josephus;

public class Solution {
    public static int josephus(int n, int k) {
        if (n == 1)
            return 0;
        else
            return (josephus(n - 1, k) + k) % n;

    }

    public static void main(String[] args) {
        System.out.println(Solution.josephus(5, 3));
    }
}
