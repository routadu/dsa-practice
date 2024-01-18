package problems.linkedlist.deletemiddlenode;

import problems.linkedlist.ListNode;

// ? https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class Solution {
    public static ListNode deleteMiddleNode(ListNode head) {
        if (head.next == null)
            return null;
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode slowPrev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = slow.next;
        return head;
    }
}
