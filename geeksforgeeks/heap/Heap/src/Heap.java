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
        Heap heap = new Heap(5);

        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);

        heap.print();
    }

    private void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
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
            System.out.println(parent(i));
            if (arr[parent(i)] > arr[i]) {
                break;
            }

            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;

            i = parent(i);
        }
    }

    private int parent(int val) {
        return val / 2;
    }
}
