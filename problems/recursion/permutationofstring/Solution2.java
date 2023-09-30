package problems.recursion.permutationofstring;

public class Solution2 {

    private static String insert(String str, int index, char c) {
        String firstPart = str.substring(0, index);
        String lastPart = str.substring(index);
        return firstPart + c + lastPart;
    }

    private static void permutation(String p, String u) {
        if (u.length() == 0) {
            System.out.print(p + " ");
            return;
        }
        char part = u.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            permutation(insert(p, i, part), u.substring(1));
        }
    }

    public static void permutation(String s) {
        permutation("", s);
    }

    public static void main(String[] args) {
        permutation("abcd");
    }
}
