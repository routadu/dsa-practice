package problems.linkedlist.oddeven;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/odd-even-linked-list/description/

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddList = head, evenList = head.next;
        ListNode oddListNode = oddList, evenListNode = evenList;
        ListNode oddListNext, evenListNext;
        while (evenListNode != null && evenListNode.next != null) {
            oddListNext = oddListNode.next.next;
            evenListNext = evenListNode.next.next;
            oddListNode.next = oddListNext;
            evenListNode.next = evenListNext;
            oddListNode = oddListNext;
            evenListNode = evenListNext;
        }
        oddListNode.next = evenList;
        return oddList;
    }
}
