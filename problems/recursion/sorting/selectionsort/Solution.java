package problems.recursion.sorting.selectionsort;

import utils.Arrays;

public class Solution {

    public static void selectionSort(int[] arr, int r, int c, int maxC) {
        if (r == 0)
            return;
        else if (c == r) {
            Arrays.swap(arr, maxC, c - 1);
            selectionSort(arr, r - 1, 0, 0);
        } else {
            selectionSort(arr, r, c + 1, arr[c] > arr[maxC] ? c : maxC);
        }

    }

    public static void main(String[] args) {
        int[] arr = Arrays.unsortedArraySample;
        Arrays.toString(arr);
        selectionSort(arr, arr.length, 0, 0);
        Arrays.toString(arr);
    }
}
