package problems.recursion.sorting.bubblesort;

import utils.Arrays;

public class Solution {

    public static void bubblesort(int arr[], int r, int c) {
        if (r == 1)
            return;
        if (c < r - 1) {
            if (arr[c] > arr[c + 1])
                Arrays.swap(arr, c, c + 1);
            bubblesort(arr, r, c + 1);
        } else {
            bubblesort(arr, r - 1, 0);
        }
    }

    public static void main(String[] args) {

        int[] arr = Arrays.unsortedArraySample;
        Arrays.toString(arr);
        bubblesort(arr, arr.length, 0);
        Arrays.toString(arr);
    }
}
