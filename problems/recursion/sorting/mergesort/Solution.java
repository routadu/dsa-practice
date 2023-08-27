package problems.recursion.sorting.mergesort;

import java.util.ArrayList;

import utils.Arrays;

public class Solution {

    private static int[] merge(int[] left, int[] right) {
        ArrayList<Integer> newList = new ArrayList<>();
        int li = 0, ri = 0, arri = 0;
        while (li < left.length && ri < right.length) {
            if (left[li] < right[ri]) {
                newList.add(left[li]);
                li++;
            } else {
                newList.add(right[ri]);
                ri++;
            }
        }
        while (li < left.length) {
            newList.add(left[li]);
            li++;
        }
        while (ri < right.length) {
            newList.add(right[ri]);
            ri++;
        }
        int[] arr = new int[newList.size()];
        for (int i : newList) {
            arr[arri++] = i;
        }
        newList.clear();
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] leftArr = mergeSort(java.util.Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = mergeSort(java.util.Arrays.copyOfRange(arr, mid, arr.length));
        return merge(leftArr, rightArr);

    }

    public static void main(String[] args) {
        int[] arr = Arrays.unsortedArraySample;
        Arrays.toString(arr);
        arr = mergeSort(arr);
        Arrays.toString(arr);

    }
}
