package problems.linkedlist.pallindromeLinkedList;

import java.util.Stack;

import problems.linkedlist.ListNode;

public class Solution {
    public static boolean isPallindrome(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
            stk.push(currNode.val);
            currNode = currNode.next;
        }
        while (head != null && !stk.isEmpty()) {
            if (head.val != stk.pop())
                return false;
            head = head.next;
        }
        return head == null && stk.isEmpty();
    }
}
