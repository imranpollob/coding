
class Node {
    int value;
    Node next;
    Node prev;

    Node(int val) {
        value = val;
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;

        first = addFirst(first, 5);
        first = addLast(first, 35);

        printList(first);

        first = reverse(first);
        System.out.println("After reverse");
        printList(first);
        System.out.println("Remove first element");
        first = removeFirst(first);
        printList(first);
        System.out.println("Remove last element");
        first = removeLast(first);
        printList(first);
    }

    private static Node removeLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.prev.next = null;
        cur.prev = null;

        return head;

    }

    private static Node removeFirst(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node cur = head;
        Node tempPrev = null;

        while (cur != null) {
            tempPrev = cur.prev;
            cur.prev = cur.next;
            cur.next = tempPrev;
            cur = cur.prev;
        }

        return tempPrev.prev;
    }

    private static Node addLast(Node first, int val) {
        Node temp = new Node(val);
        Node cur = first;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = temp;
        temp.prev = cur;

        return first;
    }

    private static Node addFirst(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        head.prev = temp;
        return temp;
    }

    private static void printList(Node head) {
        if (head == null)
            return;

        System.out.println(head.value);

        printList(head.next);
    }

}
