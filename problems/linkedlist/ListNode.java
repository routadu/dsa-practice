package problems.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        val = arr[0];
        if (arr.length > 0) {
            this.next = new ListNode(arr[1]);
            ListNode nextNode = this.next;
            for (int i = 2; i < arr.length; i++) {
                nextNode.next = new ListNode(arr[i]);
                nextNode = nextNode.next;
            }
        }

    }

    public void print() {
        System.out.print(val + " -> ");
        ListNode nxtNode = next;
        while (nxtNode != null) {
            System.out.print(nxtNode.val + " -> ");
            nxtNode = nxtNode.next;
        }
        System.out.println();
    }

}