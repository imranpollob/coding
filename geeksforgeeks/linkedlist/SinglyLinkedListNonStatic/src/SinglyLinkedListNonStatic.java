class Node {
    int value;
    Node next;

    Node(int val) {
        value = val;
    }
}

public class SinglyLinkedListNonStatic {
    Node head;

    public static void main(String[] args) {
        SinglyLinkedListNonStatic sll = new SinglyLinkedListNonStatic();

        sll.insert(1);
        sll.insert(2);
        sll.insert(3);
        sll.insert(4);

        sll.addFirst(10);
        sll.addFirst(20);

        System.out.println("List");
        sll.list();

        System.out.println("Remove first");
        sll.removeFirst();
        sll.callListRec();

        System.out.println("Remove last");
        sll.removeLast();
        sll.callListRec();

        System.out.println("Remove 1");
        sll.remove(1);
        sll.list();

        System.out.println("Insert at position 1");
        sll.insert(1, 100);
        sll.list();
    }

    private void insert(int pos, int val) {
        int position = 0;

        if (pos == 0) {
            addFirst(val);
            return;
        }

        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (pos == position) {
                Node temp = new Node(val);
                temp.next = cur;
                prev.next = temp;
            }

            position++;
            prev = cur;
            cur = cur.next;
        }

        if (pos == position) {
            insert(val);
        }

    }

    private void remove(int val) {
        if (head == null)
            return;

        // handling the first case
        if (head.value == val) {
            head = head.next;
            return;
        }

        Node cur = head;
        Node prev = null;

        // 1 2 3

        while (cur != null) {
            if (cur.value == val) {
                prev.next = cur.next;
                break;
            }

            prev = cur;
            cur = cur.next;
        }
    }

    private void removeFirst() {
        if (head == null)
            return;

        head = head.next;
    }

    private void removeLast() {
        if (head == null)
            return;

        Node cur = head;
        Node prev = null;

        // 1 2 3

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;
    }

    private void callListRec() {
        listRec(head);
    }

    private void listRec(Node node) {
        if (node == null)
            return;

        System.out.println(node.value);
        listRec(node.next);
    }

    private void addFirst(int val) {
        Node temp = new Node(val);

        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    private void list() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node cur = head;

            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = new Node(val);
        }

    }

}
