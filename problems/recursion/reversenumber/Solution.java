package problems.recursion.reversenumber;

public class Solution {
    public static int reverse(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 * (int) Math.pow(10, (int) Math.log10(n)) + reverse(n / 10);
    }

    public static void main(String[] args) {
        int result = reverse(2847239);
        System.out.println(result);
    }
}
