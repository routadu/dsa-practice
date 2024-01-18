package problems.linkedlist.reverseBetween;

import problems.linkedlist.ListNode;

public class Solution {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        if (head.next == null)
            return null;
        ListNode leftPrev = null, currNode = head;
        for (int i = 1; i < left; i++) {
            if (i == left - 1)
                leftPrev = currNode;
            currNode = currNode.next;
        }
        ListNode leftNode = currNode, nxtNode = currNode.next, tmpNode;
        currNode.next = null;
        for (int i = left; i < right; i++) {
            tmpNode = nxtNode.next;
            nxtNode.next = currNode;
            currNode = nxtNode;
            nxtNode = tmpNode;
        }
        if (leftPrev == null) {
            head = currNode;
            leftNode.next = nxtNode;
        } else {
            leftPrev.next = currNode;
            leftNode.next = nxtNode;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode ln = new ListNode(arr);
        ln.print();
        ln = reverseBetween(ln, 2, 4);
        ln.print();
    }
}
