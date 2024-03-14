record ListNode(int value, ListNode next) {
}

record SinglyLinkedList(ListNode root) {
}

public class Rekursion{
    static SinglyLinkedList addFirst(final SinglyLinkedList list, final int value) {
        return new SinglyLinkedList(new ListNode(value, list.root()));
    }

    static String toString (final SinglyLinkedList list) {
        return null;
    }
}