package problems.linkedlist.sort;

import problems.linkedlist.ListNode;

public class Solution {

    /**
     * ! This method returns the middle node and
     * ! also breaks the linkedlist at the middle
     */
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head, slowPrev = new ListNode(0);
        try {
            while (fast.next != null) {
                slowPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            slowPrev.next = null;
            return slow;
        } catch (Exception e) {
            slowPrev.next = null;
            return slow;
        }
    }

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

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = middleNode(head);
        ListNode leftNode = mergeSortList(head);
        ListNode rightNode = mergeSortList(midNode);

        return merge(leftNode, rightNode);

    }

    private static ListNode getNode(ListNode head, int index) {
        int count = 0;
        ListNode currNode = head;
        while (currNode != null) {
            if (count == index)
                return currNode;
            else {
                currNode = currNode.next;
                count++;
            }
        }
        return null;
    }

    public static ListNode bubbleSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode p1 = head, p2 = head.next, prev = head;
        while (p1 != null) {
            p1 = p1.next;
            length++;
        }
        p1 = head;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                prev = j == 1 ? null : getNode(head, j - 2);
                p1 = getNode(head, j - 1);
                p2 = getNode(head, j);
                if (p1.val > p2.val) {
                    if (p1 == head) {
                        p1.next = p2.next;
                        p2.next = p1;
                        head = p2;
                    } else {
                        prev.next = p2;
                        p1.next = p2.next;
                        p2.next = p1;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        ListNode ln = new ListNode(arr);
        ln.print();
        ln = bubbleSortList(ln);
        ln.print();
    }
}
