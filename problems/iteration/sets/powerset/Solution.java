package problems.iteration.sets.powerset;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static ArrayList<String> powerset(String currStr) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        result.add(String.valueOf(currStr.charAt(0)));
        for (int i = 1; i < currStr.length(); i++) {
            for (int j = 0; j < (int) Math.pow(2, i); j++) {
                result.add(result.get(j) + currStr.charAt(i));
            }
        }
        return result;
    }

    public static List<List<Integer>> powerset(int[] lst) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        final List<Integer> firstList = new ArrayList<>();
        firstList.add(lst[0]);
        result.add(firstList);
        for (int i = 1; i < lst.length; i++) {
            for (int j = 0; j < (int) Math.pow(2, i); j++) {
                final List<Integer> cpy = new ArrayList<>();
                cpy.addAll(result.get(j));
                cpy.add(lst[i]);
                result.add(cpy);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2 };
        final List<List<Integer>> result = powerset(arr);
        System.out.println(result);
    }
}
