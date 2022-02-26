import java.util.Iterator;

public class Heap {
    int[] arr;
    int size;
    int capacity;

    public Heap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        Heap h = new Heap(11);

        h.insert(3);
        h.insert(2);
        h.insert(1);
        h.insert(4);
        h.print();
        h.deleteKey(0);
        h.print();
        h.insert(15);
        h.insert(20);
        h.print();
        System.out.println(h.extractMin());
        h.print();
        h.decreaseKey(2, 1);
        h.print();
        System.out.println(h.extractMin());
        h.print();
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    private void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void insert(int val) {
        if (size == capacity) {
            return;
        }

        size++;
        arr[size - 1] = val;
        int i = size - 1;

        // alternative for loop
        // for (int i = size - 1; i != 0;)

        while (i != 0) {
            if (arr[parent(i)] < arr[i]) {
                break;
            }

            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;

            i = parent(i);
        }
    }

    public void minHeapify(int i) {
        int lt = left(i);
        int rt = right(i);
        int smallest = i;

        if (lt < size && arr[lt] < arr[i])
            smallest = lt;

        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }

        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;

        minHeapify(0);

        return arr[size];
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;

        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
}
