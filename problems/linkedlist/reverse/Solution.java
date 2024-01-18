package problems.linkedlist.reverse;

import problems.linkedlist.ListNode;

public class Solution {

    static ListNode ans;

    public static ListNode reverseRecursive(ListNode node) {
        if (node.next == null) {
            ans = node;
            return node;
        }
        ListNode res = reverseRecursive(node.next);
        node.next = null;
        res.next = node;
        return node;
    }

    public static ListNode reverseIterative(ListNode head) {
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

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        ListNode ln = new ListNode(arr);
        ln.print();
        reverseRecursive(ln);
        ln = ans;
        ln.print();
    }
}
