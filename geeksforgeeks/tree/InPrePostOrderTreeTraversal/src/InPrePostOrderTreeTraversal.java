
public class InPrePostOrderTreeTraversal {

	public static void main(String[] args) {
		/**
		 * 1 -> 2 3 2 -> 4 5
		 * 
		 * preorder: 1 2 4 5 3 
		 * inorder: 4 2 5 1 3 
		 * postorder: 4 2 5 1 3
		 **/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.print("Preorder traversal: ");
		preOrder(root);
		System.out.print("\nInorder traversal: ");
		inOrder(root);
		System.out.print("\nPostorder traversal: ");
		postOrder(root);

	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.value + " ");

		preOrder(root.left);

		preOrder(root.right);
	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);

		System.out.print(root.value + " ");

		inOrder(root.right);
	}

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);

		postOrder(root.right);

		System.out.print(root.value + " ");
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