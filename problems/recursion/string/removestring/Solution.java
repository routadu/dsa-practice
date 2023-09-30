package problems.recursion.string.removestring;

public class Solution {

    public static String removeString(String str, String rStr, int i) {
        if (i + rStr.length() >= str.length())
            return "";
        if (str.substring(i).startsWith(rStr))
            return removeString(str, rStr, i + rStr.length());
        else
            return String.valueOf(str.charAt(i)) + removeString(str, rStr, i + 1);
    }

    public static String removeString2(String str, String rStr) {
        if (str.isEmpty())
            return "";
        if (str.startsWith(rStr))
            return removeString2(str.substring(rStr.length()), rStr);
        else
            return str.charAt(0) + removeString2(str.substring(1), rStr);
    }

    public static void main(String[] args) {
        System.out.println(removeString("Hello world, I am world, I will rule the world", "world", 0));
    }
}
