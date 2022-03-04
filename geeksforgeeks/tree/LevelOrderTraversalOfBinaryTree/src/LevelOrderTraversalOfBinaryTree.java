import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfBinaryTree {

	public static void main(String[] args) {
		// Create the following Binary Tree
		//    1
		//   / \
		//  2   3
		// / \
		// 4 5
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		traverse(root);
	}

	private static void traverse(Node root) {
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node pop = queue.poll();
			System.out.print(pop.value + " ");

			if (pop.left != null) {
				queue.add(pop.left);
			}

			if (pop.right != null) {
				queue.add(pop.right);
			}
		}

	}

}

class Node {
	int value;
	Node left;
	Node right;

	Node(int val) {
		value = val;
		left = null;
		right = null;
	}
}
