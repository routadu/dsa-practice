package problems.linkedlist.mergetwosortedlist;

import problems.linkedlist.ListNode;

public class Solution {

    private static ListNode merge(ListNode n1, ListNode n2) {
        ListNode node = new ListNode(0), currNode = node, n1c = n1, n2c = n2;
        while (n1c != null && n2c != null) {
            if (n1c.val < n2c.val) {
                currNode.next = new ListNode(n1c.val);
                n1c = n1c.next;
            } else {
                currNode.next = new ListNode(n2c.val);
                n2c = n2c.next;
            }
            currNode = currNode.next;
        }
        while (n1c != null) {
            currNode.next = new ListNode(n1c.val);
            currNode = currNode.next;
            n1c = n1c.next;
        }
        while (n2c != null) {
            currNode.next = new ListNode(n2c.val);
            currNode = currNode.next;
            n2c = n2c.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 7, 8, 9 };
        int[] arr2 = { 2, 4, 6, 7, 9, 789, 6543 };
        ListNode ln1 = new ListNode(arr), ln2 = new ListNode(arr2);
        ln1.print();
        ln2.print();
        ListNode ln = merge(ln1, ln2);
        ln.print();
    }
}
