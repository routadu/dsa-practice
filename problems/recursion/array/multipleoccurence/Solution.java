package problems.recursion.array.multipleoccurence;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static ArrayList<Integer> multipleoccurence(int[] arr, int target, int index) {
        if (index >= arr.length)
            return new ArrayList<>();
        ArrayList<Integer> ans = multipleoccurence(arr, target, index + 1);
        if (arr[index] == target)
            ans.add(index);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 24, 45, 13, 3, 453, 35, 356, 79, 45, 892, 23, 456, 45, 23, 44, 456 };
        ArrayList<Integer> result = multipleoccurence(arr, 45, 0);
        Collections.sort(result);
        System.out.println(result.toString());
    }
}
