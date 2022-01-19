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
		//    1
		//   / \
		//  2   3
		// / \
		//4   5
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		insertNode(root, 6);
		
		preOrder(root);
	}

	private static void insertNode(Node root, int i) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp.left == null) {
				temp.left = new Node(i);
				break;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = new Node(i);
				break;
			} else {
				queue.add(temp.right);
			}
		}
	}
	
	private static void preOrder(Node root) {
		if (root == null) return;
		
		System.out.print(root.value + " ");
		
		preOrder(root.left);

		preOrder(root.right);	
	}

}
