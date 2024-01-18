package problems.linkedlist.pallindromeLinkedList;

import problems.linkedlist.ListNode;

public class Solution2 {

    public static boolean isPallindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, cur, nxt;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reversing the second half of the linkedlist
        cur = slow;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        // comparing the reversed list with head till midpoint
        ListNode comp = prev;
        while (comp != null) {
            if (head.val != comp.val)
                return false;
            head = head.next;
            comp = comp.next;
        }
        return true;
    }
}
