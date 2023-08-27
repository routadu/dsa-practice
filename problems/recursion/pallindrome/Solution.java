package problems.recursion.pallindrome;

public class Solution {

    public static boolean isPallindrome(String text, int left, int right) {
        if (left >= right)
            return true;
        else if (text.charAt(left) != text.charAt(right))
            return false;
        else
            return isPallindrome(text, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String text = "MissiissiM";
        System.out.println(text + " is pallindrome: " + isPallindrome(text, 0, text.length() - 1));
    }
}
