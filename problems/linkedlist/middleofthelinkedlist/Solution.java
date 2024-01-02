package problems.linkedlist.middleofthelinkedlist;

import problems.linkedlist.ListNode;

public class Solution {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        try {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        } catch (Exception e) {
            return slow;
        }
    }
}
