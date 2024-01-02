package problems.linkedlist;

public class CircularLinkedList {
    private class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    private Node head, tail;
    private int size;

    CircularLinkedList(int num) {
        head = new Node(num);
        tail = head;
        size = 1;
    }

    CircularLinkedList(int[] arr) {
        head = new Node(arr[0]);
        tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        tail.next = head;
        size = arr.length;
    }

    void insertFirst(int num) {
        Node newNode = new Node(num, head);
        tail.next = newNode;
        head = newNode;
        size++;
    }

    void insertLast(int num) {
        Node newNode = new Node(num, head);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int num, int pos) {
        assert pos > 0 && pos < size;
        Node newNode = new Node(num);
        Node currNode = head;
        for (int i = 0; i < pos - 1; i++) {
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    void delete(int num) {
        Node currNode = head, prevNode = null;
        while (currNode.val != num && !(currNode == head && prevNode != null)) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode.val != num)
            return;
        if (currNode == head) {
            head = head.next;
            tail.next = head;
        } else if (currNode == tail) {
            prevNode.next = head;
            tail = prevNode;
        } else {
            prevNode.next = currNode.next;
        }
        size--;
    }

    void print() {
        Node currNode = head;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out
                .println(currNode.val + " -> " + currNode.next.val + "(head) [head: " + head.val + ", tail: " + tail.val
                        + ", size: " + size + "]");
    }
}
