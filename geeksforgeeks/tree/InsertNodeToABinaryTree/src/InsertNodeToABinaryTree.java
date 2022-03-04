import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    Node(int val) {
        value = val;
        right = null;
        left = null;
    }
}

public class InsertNodeToABinaryTree {
    static Node root;

    public static void main(String[] args) {
        // Create the following Binary Tree
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        insert(root, 6);
        insert(root, 11);

        preOrder(root);
    }

    private static void insert(Node head, int val) {
        Node new_node = new Node(val);
        Queue<Node> q = new LinkedList<Node>();

        q.add(head);

        while (!q.isEmpty()) {
            Node dequeued_node = q.poll();

            if (dequeued_node.left == null) {
                dequeued_node.left = new_node;
                break;
            } else {
                q.add(dequeued_node.left);
            }

            if (dequeued_node.right == null) {
                dequeued_node.right = new_node;
                break;
            } else {
                q.add(dequeued_node.right);
            }
        }

    }

    private static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");

        preOrder(root.left);

        preOrder(root.right);
    }

}
