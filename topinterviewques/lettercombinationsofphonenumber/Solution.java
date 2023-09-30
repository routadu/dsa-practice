package topinterviewques.lettercombinationsofphonenumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static int getRange(int num) {
        if (num == 7 || num == 9)
            return 4;
        else
            return 3;
    }

    private static char getCharacter(int num, int index) {
        if (num < 7) {
            return (char) (97 + (num - 2) * 3 + index);
        } else if (num == 7) {
            return (char) (112 + index);
        } else if (num == 8) {
            return (char) (116 + index);
        } else {
            return (char) (119 + index);
        }
    }

    private static void letterCombinations(String letter, String processed, List<String> result) {
        if (letter.length() == 0) {
            if (processed.length() != 0)
                result.add(processed);
            return;
        }
        int currNum = letter.charAt(0) - '0';
        int currNumRange = getRange(currNum);
        for (int i = 0; i < currNumRange; i++) {
            letterCombinations(letter.substring(1), processed + getCharacter(currNum, i), result);
        }
    }

    public static List<String> letterCombinations(String letter) {
        ArrayList<String> result = new ArrayList<>();
        letterCombinations(letter, "", result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("2345");
        System.out.println(result);
    }
}
