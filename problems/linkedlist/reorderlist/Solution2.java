package problems.linkedlist.reorderlist;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/reorder-list/

public class Solution2 {
    public ListNode reverseIterative(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode currNode = head, nxtNode = head.next, tmpNode;
        head.next = null;
        while (nxtNode != null) {
            tmpNode = nxtNode.next;
            nxtNode.next = currNode;
            currNode = nxtNode;
            nxtNode = tmpNode;
        }
        return currNode;
    }

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null)
            return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfRevList = reverseIterative(slow.next);
        slow.next = null;
        ListNode currNode1 = head.next, currNode2 = halfRevList;
        while (currNode1 != null && currNode2 != null) {
            head.next = currNode2;
            currNode2 = currNode2.next;
            head = head.next;
            head.next = currNode1;
            currNode1 = currNode1.next;
            head = head.next;
        }
        if (currNode1 != null) {
            head.next = currNode1;
            head = head.next;
        }
        head.next = null;
    }
}
