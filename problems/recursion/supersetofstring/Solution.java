package problems.recursion.supersetofstring;

public class Solution {

    private static void superset(String str, int i, String currS) {
        if (i == str.length()) {
            System.out.print(currS + " ");
            return;
        }
        superset(str, i + 1, currS + str.charAt(i));
        superset(str, i + 1, currS);
    }

    public static void superset(String str) {
        superset(str, 0, "");
        System.out.println();
    }

    public static void main(String[] args) {
        superset("abc");
    }
}
