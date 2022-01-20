
public class StackAsArray {
	int cap;
	int size;
	int[] arr;

	public StackAsArray(int c) {
		cap = c;
		size = 0;
		arr = new int[cap];
	}

	public static void main(String[] args) {
		StackAsArray stack = new StackAsArray(5);
		stack.enque(10);
		stack.enque(20);
		stack.enque(30);
		stack.enque(40);

		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());

		stack.enque(50);
		stack.enque(60);

		System.out.println(stack.isFull());
		System.out.println(stack.getFront());
		System.out.println(stack.getRear());
		System.out.println(stack.size());

		stack.deque();
		System.out.println(stack.getRear());
		stack.deque();
		stack.deque();
		stack.deque();
		stack.deque();
		stack.deque();
		stack.deque();
		System.out.println(stack.getRear());

		System.out.println(stack.isEmpty());
		
		stack.enque(60);
		System.out.println(stack.getRear());
	}

	void enque(int x) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}

		arr[size] = x;
		size++;
	}

	void deque() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		size--;
	}

	int getFront() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}

		return arr[0];
	}

	int getRear() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}

		return arr[size - 1];
	}

	boolean isFull() {
		return size == cap;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}

}