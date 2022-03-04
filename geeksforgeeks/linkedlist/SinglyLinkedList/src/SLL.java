
public class SLL {
    Node head;

    public void addFirst(int val) {
        Node new_node = new Node(val);

        if (head == null) {
            head = new_node;
            return;
        }

        new_node.next = head;
        head = new_node;
    }

    public void addLast(int val) {
        Node new_node = new Node(val);

        if (head == null) {
            head = new_node;
            return;
        }

        Node cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new_node;
    }

    public void insert(int pos, int val) {
        if (pos == 0) {
            addFirst(val);
            return;
        }

        int i = 0;
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (i == pos) {
                Node new_node = new Node(val);
                prev.next = new_node;
                new_node.next = cur;
                return;
            }

            prev = cur;
            cur = cur.next;
            i++;
        }
    }

    public void removeFirst() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        head = head.next;
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node cur = head;
        Node prev = null;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;
    }

    public void delete(int val) {
        if (head == null) {
            return;
        }

        if (head.value == val) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
                return;
            }
        }

        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (cur.value == val) {
                prev.next = cur.next;
                return;
            }

            prev = cur;
            cur = cur.next;
        }
    }

    public void search(int val) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node cur = head;
        int pos = 0;

        while (cur != null) {
            if (cur.value == val) {
                System.out.println(val + " is found at position " + pos);
                return;
            }

            cur = cur.next;
            pos++;
        }

        System.out.println(val + " is not found");

    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
        }

        Node cur = head;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }

        System.out.println();
    }

    public void changeVal() {
        // TODO Auto-generated method stub

    }

    public void printRec() {
        _printRec(head);
        System.out.println();
    }

    private void _printRec(Node node) {
        if (node == null) {
            return;
        }
        
        System.out.print(node.value + " ");
        
        _printRec(node.next);
    }

    public void checkloop() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                System.out.println("Loop exist" + slow.value + " " + fast.value);
                return;
            }
        }
        
        System.out.println("No loop exist");

    }

    public void removeloop() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (slow != fast) {
            return;
        }
        
        slow = head;
        
        while(slow.next != fast.next ) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = null;
    }

    public void reversePrint() {
        _reversePrint(head);
        System.out.println();
    }

    private void _reversePrint(Node node) {
        if (node == null) {
            return;
        }
        
        _reversePrint(node.next);
        
        System.out.print(node.value + " ");
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        
        Node cur = head;
        Node prev = null;
        Node next = null;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        head = prev;
    }

    public void createloop(int s, int d) {
        Node cur = head;
        Node source = null;
        Node des = null;
        
        while(cur != null) {
            if (cur.value == s) {
                source = cur;
            } 
            
            if (cur.value == d) {
                des = cur;
            }
            
            if (source != null && des != null) {
                break;
            }
            
            cur = cur.next;
        }
        
        if (source != null && des != null) {
            source.next = des;
        }
    }

}
