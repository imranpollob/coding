package geeksforgeeks.linkedlist;

public class SimpleImplmentation {

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.next = b;
		b.next = c;
	}

}

class Node {
	int value;
	Node next;
	
	Node(int value){
		this.value = value;
		this.next = null;
	}
}