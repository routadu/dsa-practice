package problems.recursion.string.removecharacter;

public class Solution {

    public static String removeCharacter(String str, char rChar, int i) {
        if (i == str.length())
            return "";
        String currentSelected = String.valueOf(str.charAt(i) == rChar ? '\0' : str.charAt(i));
        return currentSelected.concat(removeCharacter(str, rChar, i + 1));
    }

    public static void main(String[] args) {
        System.out.println(removeCharacter("Hello World, I am Aditya", 'l', 0));
    }
}
