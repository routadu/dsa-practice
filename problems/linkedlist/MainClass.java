package problems.linkedlist;

public class MainClass {
    public static void main(String[] args) {
        int[] arr = { 12, 24, 89, 2, 345, 1, 78, 411, 897 };
        SinglyLinkedList sll = new SinglyLinkedList(arr);
        sll.print();
        sll.insertRecursive(667, 0);
        sll.print();

    }
}
