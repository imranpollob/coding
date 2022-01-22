
class Node{
	int value;
	Node left, right;
	
	Node(int val) {
		value = val;
	}
}


public class SearchInBinarySearchTree {

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
		
		search(root, 118);
		search(root, 12);
		iterativeSearch(root, 152);		
		iterativeSearch(root, 5);		
	}
	
	private static void iterativeSearch(Node root, int key) {
		while (root != null) {
			if (root.value == key) {
				System.out.println("Found");
				return;
			}
			
			if (key < root.value) {
				root = root.left;
			}

			if (key > root.value) {
				root = root.right;
			}
		}
		
		System.out.println("Opps not found");
	}

	public static void search(Node root, int key) {
		if (root == null) {
			System.out.println("Opps not found");
			return;
		}
		
		if (root.value == key) {
			System.out.println("Found");
		}
		
		if (key < root.value) {
			search(root.left, key);
		}
		
		if (key > root.value) {
			search(root.right, key);
		}
	}

}
