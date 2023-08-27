package problems.recursion.noofzeroes;

public class Solution {

    public static int noofzeroes(int n) {
        if (n == 0)
            return 0;
        if (n % 10 == 0)
            return 1 + noofzeroes(n / 10);
        else
            return 0 + noofzeroes(n / 10);
    }

    static int noofzeroes2(int n, int count) {
        if (n == 0)
            return count;
        if (n % 10 == 0)
            count++;
        return noofzeroes2(n / 10, count);
    }

    public static void main(String[] args) {
        int result = noofzeroes2(103104, 0);
        System.out.println(result);
    }
}
