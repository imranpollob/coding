class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class SinglyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        listNodes(head);
        head = addFirst(head, 50);
        head = addFirst(head, 60);
        head = addFirst(head, 70);

        Node new_head = null;
        new_head = addFirst(new_head, 1000);
        new_head = addFirst(new_head, 2000);
        listNodesRecursively(new_head);

        new_head = addLast(new_head, 3000);
        new_head = addLast(new_head, 4000);
        listNodes(new_head);

        Node new_head2 = null;
        new_head2 = addLast(new_head2, 70);
        new_head2 = addLast(new_head2, 80);
        new_head2 = addLast(new_head2, 90);
        new_head2 = addLast(new_head2, 100);
        System.out.println("List");
        listNodesRecursively(new_head2);

        new_head2 = remove(new_head2, 70);
        System.out.println("List again");
        listNodes(new_head2);

        System.out.println("Removing from the first");
        new_head2 = removeFirst(new_head2);
        listNodes(new_head2);
        System.out.println("Removing from the first");
        new_head2 = removeFirst(new_head2);
        listNodes(new_head2);
        System.out.println("Removing from the last");
        new_head2 = removeLast(new_head2);
        listNodes(new_head2);
        System.out.println("Removing from the last");
        new_head2 = removeLast(new_head2);
        listNodes(new_head2);
    }

    private static Node remove(Node head, int key) {
        Node cur = head;
        Node prev = null;

        if (cur == null) {
            return null;
        }

        if (head.value == key) {
            return head.next;
        }

        while (cur != null) {
            if (cur.value == key) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    private static Node removeFirst(Node head) {
        if (head == null) {
            return null;
        }

        return head.next;
    }

    private static Node removeLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;

        return head;
    }

    private static void listNodes(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void listNodesRecursively(Node head) {
        if (head == null)
            return;

        System.out.println(head.value);
        listNodesRecursively(head.next);
    }

    private static Node addFirst(Node head, int value) {
        Node new_head = new Node(value);
        new_head.next = head;
        return new_head;
    }

    private static Node addLast(Node head, int value) {
        Node temp = new Node(value);

        if (head == null) {
            return temp;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = temp;

        return head;
    }

}
