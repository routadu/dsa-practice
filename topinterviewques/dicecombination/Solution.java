package topinterviewques.dicecombination;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static void combination(int num, String p, List<String> result) {
        if (num == 0) {
            result.add(p);
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (num - i >= 0)
                combination(num - i, p + i, result);
        }
    }

    public static List<String> combination(int num) {
        ArrayList<String> result = new ArrayList<>();
        combination(num, "", result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = combination(4);
        System.out.println(result);
    }
}
