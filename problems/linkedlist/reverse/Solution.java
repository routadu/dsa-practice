package problems.linkedlist.reverse;

import problems.linkedlist.ListNode;
import problems.linkedlist.LinkedList;

public class Solution {

    public static ListNode reverse(LinkedList lst) {
        if (lst.head == null || lst.head.next == null) {
            return lst.head;
        }
        ListNode prevNode = lst.head, currNode = lst.head.next, nextNode;
        prevNode.next = null;
        do {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        } while (nextNode != null);
        return prevNode;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 6, 22, 56, 89, 234 };
        LinkedList linlist = new LinkedList(arr);
        linlist.head = reverse(linlist);
        linlist.print();
    }
}
