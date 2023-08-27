package problems.recursion.pattern;

public class Solution {

    public static void pattern1(int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            System.out.print("*");
            pattern1(r, c + 1);
        } else {
            System.out.println();
            pattern1(r - 1, 0);
        }
    }

    public static void pattern1Reverse(int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            pattern1Reverse(r, c + 1);
            System.out.print("*");
        } else {
            pattern1Reverse(r - 1, 0);
            System.out.println();
        }
    }

    public static void triangle(int n, int r, int c) {

        if (r == n && c == r) {
            return;
        }
        if (c < r) {
            System.out.print("*");
            triangle(n, r, c + 1);
            if (r != n)
                System.out.print("*");
        } else {
            System.out.println();
            triangle(n, r + 1, 0);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // pattern1Triangle(5);
        triangle(5, 0, 0);
    }
}
