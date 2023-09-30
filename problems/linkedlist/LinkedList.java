package problems.linkedlist;

public class LinkedList {

    public ListNode head;

    public LinkedList(int val) {
        head = new ListNode(val);
    }

    public LinkedList(int[] arr) {
        head = new ListNode(arr[0]);
        ListNode currNode = head;
        for (int i = 1; i < arr.length; i++) {
            currNode.next = new ListNode(arr[i]);
            currNode = currNode.next;
        }
    }

    public void print() {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.println("end");
    }

}
