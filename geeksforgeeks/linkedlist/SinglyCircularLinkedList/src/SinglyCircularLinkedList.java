
class Node {
    int value;
    Node next;

    Node(int val) {
        value = val;
    }
}

public class SinglyCircularLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;

        printList(head);
        head = insertFirst(head, 5);
        System.out.println("Inserting at first position");
        printList(head);
        head = insertLast(head, 35);
        System.out.println("Inserting at last position");
        printList(head);
        head = deleteFirst(head);
        System.out.println("Deleting first element");
        printList(head);
    }

    private static Node deleteFirst(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node cur = head;

        while (cur.next != head) {
            cur = cur.next;
        }

        cur.next = head.next;

        return cur.next;
    }

    private static Node insertLast(Node head, int val) {
        Node temp = new Node(val);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        Node cur = head;

        while (cur.next != head) {
            cur = cur.next;
        }

        cur.next = temp;
        temp.next = head;

        return head;
    }

    private static Node insertFirst(Node head, int val) {
        Node temp = new Node(val);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        Node cur = head;

        while (cur.next != head) {
            cur = cur.next;
        }

        temp.next = head;
        cur.next = temp;

        return temp;
    }

    private static void printList(Node head) {
        if (head == null)
            return;

        Node cur = head;

        do {
            System.out.println(cur.value);
            cur = cur.next;
        } while (cur != head);
    }

}
