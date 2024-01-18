package problems.linkedlist.rotateList;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/rotate-list/description/

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        int timesToShift = k % length;
        for (int i = 0; i < timesToShift; i++) {
            head = head.next;
        }
        tail = head;
        for (int i = 0; i < length - 1; i++) {
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
