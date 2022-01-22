
class Node{
	int value;
	Node left, right;
	
	Node(int val) {
		value = val;
	}
}


public class InsertInBinarySearchTree {

	public static void main(String[] args) {
		/**
		 * 		10
		 * 		/ \
		 * 	   5  15
		 * 	      / \
		 * 		12  18
		 */
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right = new Node(18);

		insert(root, 7);
		insert(root, 17);
		insert(root, 27);
		insert(root, 23);
		insert(root, 18);
		insert(root, 9);
		insert(root, 11);
	}

	private static Node insert(Node root, int key) {
		Node temp = new Node(key);
		
		if (root == null) {
			return temp;
		}
		
		if (key < root.value) {
			root.left = insert(root.left, key);
		}
		
		if (key > root.value) {
			root.right = insert(root.right, key);
		}
		
		return root;
	}

}
