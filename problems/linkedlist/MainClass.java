package problems.linkedlist;

public class MainClass {
    public static void main(String[] args) {
        int[] arr = { 32, 4324, 89, 112, 34, 111, 2, 78, 6 };
        SinglyLinkedList sll = new SinglyLinkedList(arr);
        DoublyLinkedList dll = new DoublyLinkedList(arr);
        // sll.print();
        // sll.insertFirst(890);
        // sll.insertLast(890);
        // sll.insert(890, 7);
        // sll.print();
        dll.print();
        dll.insertFirst(123);
        dll.insertLast(321);
        dll.print();
        dll.insert(444, 3);
        dll.insert(555, 8);
        dll.print();
        dll.delete(4324);
        dll.delete(555);
        dll.print();
    }
}
