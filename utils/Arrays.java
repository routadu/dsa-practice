package utils;

public class Arrays {

    public static int[] unsortedArraySample = { 4355, 324, 56, 2, 463, 90, 21, 87, 797, 3 };

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void toString(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
