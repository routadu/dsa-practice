package problems.linkedlist;

public class SinglyLinkedList {

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

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList(int val) {
        head = new Node(val);
        tail = head;
        size++;
    }

    public SinglyLinkedList(int[] arr) {
        head = new Node(arr[0]);
        tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        size = arr.length;
    }

    public void insertFirst(int num) {
        Node newNode = new Node(num, head);
        head = newNode;
        size++;
    }

    public void insertLast(int num) {
        Node node = new Node(num);
        tail.next = node;
        tail = node;
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

    private Node insertRecursive(int num, int pos, Node currNode) {
        if (pos == 0) {
            size++;
            return new Node(num, currNode);
        }
        currNode.next = insertRecursive(num, pos - 1, currNode.next);
        return currNode;
    }

    public void insertRecursive(int num, int pos) {
        head = insertRecursive(num, pos, head);
    }

    public void delete(int num) {

        Node currNode = head, prevNode = null;
        while (currNode != null) {
            if (currNode.val == num) {
                if (prevNode == null) {
                    if (tail == head)
                        clearList();
                    else
                        head = head.next;
                } else {
                    prevNode.next = currNode.next;
                    if (prevNode.next == null)
                        tail = prevNode;
                }
                size--;
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
    }

    public void reverse() {
        if (head == null || head.next == null)
            return;
        tail = head;
        Node prevNode = head, currNode = head.next, nextNode;
        prevNode.next = null;
        do {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        } while (nextNode != null);
        head = prevNode;
    }

    private void clearList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        if (head == null)
            System.out.println("[]");
        Node currNode = head;
        while (true) {
            System.out.print(currNode.val);
            currNode = currNode.next;
            if (currNode != null)
                System.out.print(" -> ");
            else
                break;
        }
        System.out.println(" [head: " + head.val + ", tail: " + tail.val + ", size: " + size + "]");
    }

}
