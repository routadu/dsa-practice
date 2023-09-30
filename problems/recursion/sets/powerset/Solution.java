package problems.recursion.sets.powerset;

public class Solution {

    private static int powersetCount = 0;

    private static void powerset(String mainString, int i, String currentString) {
        if (i == mainString.length()) {
            powersetCount++;
            System.out.print(currentString + " ");
            return;
        }
        powerset(mainString, i + 1, currentString);
        powerset(mainString, i + 1, currentString + mainString.charAt(i));
    }

    public static void powerset(String mainStr) {
        powerset(mainStr, 0, "");
        System.out.println("\n\nPowerset count: " + powersetCount);
    }

    public static void main(String[] args) {
        powerset("abcdefghijklmnopqrstuvwxyz");
    }
}
