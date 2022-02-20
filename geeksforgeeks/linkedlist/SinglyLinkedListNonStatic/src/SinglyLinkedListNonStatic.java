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

        System.out.println("Search for 100 and 5");
        sll.search(100);
        sll.search(5);
        sll.callSearchRec(2);
        sll.callSearchRec(4);
    }

    private void callSearchRec(int val) {
        // only one method from below is needed
        searchRecTail(head, val, -1);
        System.out.println("Position: " + searchRec(head, val));
    }

    private int searchRec(Node head, int val) {
        if (head == null) {
            return -1;
        }
        
        if (head.value == val)
            return 1;
        
        int res = searchRec(head.next, val);
        
        if (res == -1) {
            return -1;
        } else {
            return res + 1;
        }
        
    }

    private void searchRecTail(Node head, int val, int pos) {
        if (head == null) {
            System.out.println("Not found");
            return;
        }
        
        pos++;
        
        if (head.value == val) {
            System.out.println("Found at index " + pos);
            return;
        }

        searchRecTail(head.next, val, pos);
    }

    private void search(int val) {
        if (head == null) {
            System.out.println("Not found");
            return;
        }

        Node cur = head;
        int pos = -1;

        while (cur != null) {
            pos++;
            if (cur.value == val) {
                System.out.println("Found at index " + pos);
                return;
            }
            cur = cur.next;
        }

        System.out.println("Not found");
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
