package problems.linkedlist.cycleorigin;

import problems.linkedlist.ListNode;

public class Solution2 {
    public static ListNode detectCycle(ListNode node) {
        try {
            ListNode firstPtr = node, secondPtr = node, slowPointer = node, fastPointer = node.next;
            while (fastPointer != null) {
                if (slowPointer == fastPointer) {
                    int len = 1;
                    while (slowPointer.next != fastPointer) {
                        slowPointer = slowPointer.next;
                        len++;
                    }
                    for (int i = 0; i < len; i++) {
                        secondPtr = secondPtr.next;
                    }
                    while (firstPtr != secondPtr) {
                        firstPtr = firstPtr.next;
                        secondPtr = secondPtr.next;
                    }
                    return firstPtr;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
