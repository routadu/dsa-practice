package problems.linkedlist.reversekgroup;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class Solution {

    private ListNode reverseIterative(ListNode head) {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode currNode = head, endNode = head, endPrev = null;
        while (currNode != null) {
            for (int i = 0; i < k - 1 && currNode != null; i++) {
                currNode = currNode.next;
            }
            if (currNode == null)
                break;
            ListNode nxtNode = currNode.next;
            currNode.next = null;
            ListNode result = reverseIterative(endNode);
            if (endNode == head) {
                head = result;
            } else {
                endPrev.next = result;
            }
            endNode.next = nxtNode;
            endPrev = endNode;
            currNode = nxtNode;
            endNode = nxtNode;
        }
        return head;
    }
}
