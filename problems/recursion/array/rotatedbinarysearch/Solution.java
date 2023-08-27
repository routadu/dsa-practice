package problems.recursion.array.rotatedbinarysearch;

public class Solution {

    public static int rbs(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (target == arr[mid])
            return mid;
        boolean leftArr = arr[mid] >= arr[left];
        if (leftArr) {
            if (target > arr[mid] || target < arr[left])
                return rbs(arr, target, mid + 1, right);
            else
                return rbs(arr, target, left, mid - 1);
        } else {
            if (target < arr[mid] || target > arr[right])
                return rbs(arr, target, left, mid - 1);
            else
                return rbs(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int result = rbs(arr, 4, 0, arr.length - 1);
        System.out.println(result);
    }
}
