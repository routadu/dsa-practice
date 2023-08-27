package problems.recursion.array.sortedarray;

public class Solution {

    // checks the array from the end
    public static boolean sorted(int[] arr, int i) {
        if (i == 0)
            return true;
        if (arr[i] >= arr[i - 1])
            return sorted(arr, i - 1);
        else
            return false;
    }

    // checks the array from the beginning
    public static boolean sorted2(int[] arr, int i) {
        if (i == arr.length - 1)
            return true;
        if (arr[i] <= arr[i + 1])
            return sorted2(arr, i + 1);
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 54, 56, 76, 78, 90, 433 };
        System.out.println("From beginning: " + sorted(arr, arr.length - 1));
        System.out.println("From end: " + sorted2(arr, 0));
    }
}
