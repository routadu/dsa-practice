package problems.recursion.sorting.quicksort;

import utils.Arrays;

public class Solution {

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end)
            return;
        int s = start - 1, sc = start, pivot = end;
        while (sc < end) {
            if (arr[sc] < arr[pivot]) {
                s++;
                Arrays.swap(arr, s, sc);
            }
            sc++;
        }
        if (s < end) {
            s++;
            Arrays.swap(arr, s, pivot);
        }
        quickSort(arr, start, s - 1);
        quickSort(arr, s + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = Arrays.unsortedArraySample;
        Arrays.toString(arr);
        quickSort(arr, 0, arr.length - 1);
        Arrays.toString(arr);
    }
}
