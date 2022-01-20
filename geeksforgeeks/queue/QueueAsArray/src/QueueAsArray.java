
public class QueueAsArray {
	int cap;
	int size;
	int[] arr;

	public QueueAsArray(int c) {
		cap = c;
		size = 0;
		arr = new int[cap];
	}

	public static void main(String args[]) {
		QueueAsArray queue = new QueueAsArray(5);

		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);

		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());

		queue.enque(50);
		queue.enque(60);

		System.out.println(queue.isFull());
		System.out.println(queue.getFront());
		System.out.println(queue.getRear());
		System.out.println(queue.size());

		queue.deque();
		queue.deque();
		queue.deque();
		queue.deque();
		queue.deque();
		queue.deque();
		queue.deque();

		System.out.println(queue.isEmpty());
	}

	void enque(int x) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}

		arr[size] = x;
		size++;
	}

	void deque() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		for (int i = 0; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}

		size--;
	}

	int getFront() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}

		return arr[0];
	}

	int getRear() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
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
