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

	}

	private static void listNodes(Node head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

}
