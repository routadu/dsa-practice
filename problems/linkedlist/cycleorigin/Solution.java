package problems.linkedlist.cycleorigin;

import java.util.HashMap;

import problems.linkedlist.ListNode;

public class Solution {

    public static ListNode detectCycle(ListNode node) {
        HashMap<ListNode, Boolean> hmp = new HashMap<>();
        try {
            ListNode trackPtr = node, slowPointer = node, fastPointer = node.next;
            while (fastPointer != null) {
                if (slowPointer == fastPointer) {
                    do {
                        hmp.put(slowPointer, true);
                        slowPointer = slowPointer.next;
                    } while (slowPointer != fastPointer);
                    while (!hmp.containsKey(trackPtr)) {
                        trackPtr = trackPtr.next;
                    }
                    return trackPtr;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
