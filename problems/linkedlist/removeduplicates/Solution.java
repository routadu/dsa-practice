package problems.linkedlist.removeduplicates;

import problems.linkedlist.ListNode;

public class Solution {

    private static ListNode removeDuplicates(ListNode node, int val) {
        if (node == null)
            return null;
        if (node.val > val) {
            node.next = removeDuplicates(node.next, node.val);
            return node;
        } else {
            return removeDuplicates(node.next, val);
        }
    }

    public static void removeDuplicates(ListNode node) {
        node = removeDuplicates(node, 0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 4, 5, 6, 6, 7, 8, 8, 8, 8, 8, 9, 10, 11, 11, 12, 12, 12, 13, 15, 19 };
        ListNode ln = new ListNode(arr);
        ln.print();
        removeDuplicates(ln);
        ln.print();
    }
}
