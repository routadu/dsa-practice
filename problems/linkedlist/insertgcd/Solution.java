package problems.linkedlist.insertgcd;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

public class Solution {

    private int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null)
            return head;
        ListNode currNode = head, nextNode = head.next;
        while (nextNode != null) {
            int gcdVal = gcd(currNode.val, nextNode.val);
            currNode.next = new ListNode(gcdVal, nextNode);
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        return head;
    }
}
