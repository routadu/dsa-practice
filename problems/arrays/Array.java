package problems.arrays;

import java.util.Arrays;

public class Array {

    private static void insertShift(int[] arr, int num, int pos) {
        if (pos >= arr.length)
            return;
        if (arr[pos] == 0) {
            arr[pos] = num;
            return;
        } else {
            int val = arr[pos];
            arr[pos] = num;
            insertShift(arr, val, pos + 1);
        }
    }

    public static void insert(int[] arr, int num, int pos) {
        if (pos >= arr.length)
            return;
        if (arr[pos] == 0)
            arr[pos] = num;
        else
            insertShift(arr, num, pos);
    }

    private static int deleteShift(int[] arr, int pos) {
        if (pos >= arr.length)
            return -1;
        if (arr[pos] == 0)
            return 0;
        else {
            int nextNum = deleteShift(arr, pos + 1);
            int currNum = arr[pos];
            if (nextNum >= 0) {
                arr[pos] = nextNum;
            }
            return currNum;
        }

    }

    public static void delete(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                deleteShift(arr, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 7; i++) {
            arr[i] = i + 100;
        }
        System.out.println(Arrays.toString(arr));
        // insert(arr, 1099, 2);
        delete(arr, 105);
        System.out.println(Arrays.toString(arr));

    }
}
