package problems.linkedlist.cyclelength;

import problems.linkedlist.ListNode;

public class Solution {

    public static int cycleLength(ListNode node) {
        ListNode slowPointer = node;
        ListNode fastPointer = node.next;
        int len = 1;
        try {
            while (fastPointer != null) {
                if (slowPointer == fastPointer) {
                    while (slowPointer.next != fastPointer) {
                        len++;
                        slowPointer = slowPointer.next;
                    }
                    return len;
                }
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }

    }

    public static void main(String[] args) {

    }
}
