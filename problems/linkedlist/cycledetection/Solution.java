package problems.linkedlist.cycledetection;

import problems.linkedlist.ListNode;

public class Solution {
    public static boolean hasCycle(ListNode head) {
        try {
            ListNode slowPointer = head;
            ListNode fastPointer = head.next;
            while (fastPointer != null) {
                if (fastPointer == slowPointer)
                    return true;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}