package problems.linkedlist.reorderlist;

import java.util.ArrayList;

import problems.linkedlist.ListNode;

//? https://leetcode.com/problems/reorder-list/

public class Solution {
    public static void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null)
            return;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode result = new ListNode(0), resultPtr = result, resultPrevPtr = null, currNode = head;
        while (currNode != null) {
            arr.add(currNode.val);
            currNode = currNode.next;
        }
        int arrSize = arr.size(), iterations = arrSize / 2;
        if (arrSize % 2 != 0)
            iterations++;
        for (int i = 0; i < iterations; i++) {
            resultPtr.next = new ListNode(arr.get(i));
            resultPtr = resultPtr.next;
            resultPtr.next = new ListNode(arr.get(arrSize - 1 - i));
            resultPrevPtr = resultPtr;
            resultPtr = resultPtr.next;
        }
        if (arr.size() % 2 != 0)
            resultPrevPtr.next = null;
        head.next = result.next.next;
    }
}
