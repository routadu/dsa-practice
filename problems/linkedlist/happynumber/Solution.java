package problems.linkedlist.happynumber;

public class Solution {

    public static int computeNext(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += (int) Math.pow(digit, 2);
            num /= 10;
        }
        return sum;
    }

    public static boolean happyNumber(int num) {
        int slow = num, fast = num;
        while (fast != 1) {
            slow = computeNext(slow);
            fast = computeNext(computeNext(fast));
            if (slow == fast)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(happyNumber(19));
    }
}
