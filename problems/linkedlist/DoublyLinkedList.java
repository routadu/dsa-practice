package problems.linkedlist;

public class DoublyLinkedList {
    private class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head, tail;
    private int size;

    DoublyLinkedList(int num) {
        Node newNode = new Node(num);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    DoublyLinkedList(int[] arr) {
        head = new Node(arr[0]);
        tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i], tail, null);
            tail = tail.next;
        }
        size = arr.length;
    }

    public void insertFirst(int num) {
        Node newNode = new Node(num, null, head);
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void insertLast(int num) {
        Node newNode = new Node(num, tail, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int num, int pos) {
        assert pos > 0 && pos < size;
        boolean leftPartition = pos < size / 2;
        Node currNode, newNode, nextNode, prevNode;
        if (leftPartition) {
            currNode = head;
            for (int i = 0; i < pos - 1; i++) {
                currNode = currNode.next;
            }
            nextNode = currNode.next;
            newNode = new Node(num, currNode, nextNode);
            currNode.next = newNode;
            nextNode.prev = newNode;
        } else {
            currNode = tail;
            for (int i = 0; i < size - pos - 1; i++) {
                currNode = currNode.prev;
            }
            prevNode = currNode.prev;
            newNode = new Node(num, prevNode, currNode);
            currNode.prev = newNode;
            prevNode.next = newNode;
        }
        size++;
    }

    public void delete(int num) {
        Node currNode = head, prevNode = null;
        while (currNode != null && currNode.val != num) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            if (currNode.prev == null && currNode.next != null) {
                head = currNode.next;
                head.prev = null;
                if (size - 1 == 1)
                    tail = head;
            } else if (currNode.prev != null && currNode.next == null) {
                tail = currNode.prev;
                tail.next = null;
                if (size - 1 == 1)
                    head = tail;
            } else {
                Node nextNode = currNode.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            size--;
        }

    }

    public void print() {
        if (head == null)
            System.out.println("[]");
        Node currNode = head;
        while (true) {
            System.out.print(currNode.val);
            currNode = currNode.next;
            if (currNode != null)
                System.out.print(" <-> ");
            else
                break;
        }
        System.out.println(" [head: " + head.val + ", tail: " + tail.val + ", size: " + size + "]");
    }

    public void printReverse() {
        if (tail == null)
            System.out.println("[]");
        Node currNode = tail;
        while (true) {
            System.out.print(currNode.val);
            currNode = currNode.prev;
            if (currNode != null)
                System.out.print(" <-> ");
            else
                break;
        }
        System.out.println(" [head: " + head.val + ", tail: " + tail.val + ", size: " + size + "]");
    }

}
