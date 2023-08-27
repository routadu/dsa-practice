package problems.recursion.permutationofstring;

public class Solution {

    private static String swap(String s, int a, int b) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        StringBuilder bldr = new StringBuilder();
        for (char c : arr) {
            bldr.append(c);
        }
        return bldr.toString();
    }

    private static void permutation(String s, int l, int r) {
        if (l == r) {
            System.out.print(s + " ");
            return;
        }
        for (int i = l; i <= r; i++) {
            permutation(swap(s, l, i), l + 1, r);
        }
    }

    public static void permutation(String s) {
        permutation(s, 0, s.length() - 1);
        System.out.println();
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}
