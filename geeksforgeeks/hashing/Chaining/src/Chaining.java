import java.util.ArrayList;
import java.util.LinkedList;

public class Chaining {
    int bucket;
    ArrayList<LinkedList<Integer>> arr = new ArrayList<LinkedList<Integer>>();

    public Chaining(int val) {
        bucket = val;

        for (int i = 0; i < this.bucket; i++) {
            arr.add(new LinkedList<Integer>());
        }
    }

    public static void main(String[] args) {
        Chaining chain = new Chaining(7);

        System.out.println("Inserting elements");
        chain.insert(70);
        chain.insert(71);
        chain.insert(9);
        chain.insert(56);
        chain.insert(72);

        System.out.println(chain.arr);

        System.out.println("Searching for 56: " + chain.search(56));
        System.out.println("Searching for 51: " + chain.search(51));

        System.out.println("Deleting 56");
        chain.remove(56);

        System.out.println("Searching for 56: " + chain.search(56));

    }

    private void remove(int val) {
        int pos = val % bucket;
        arr.get(pos).remove((Integer) val);
    }

    private void insert(int val) {
        int pos = val % bucket;
        arr.get(pos).add(val);
    }

    private boolean search(int val) {
        int pos = val % bucket;

        if (arr.get(pos) != null && arr.get(pos).contains(val)) {
            return true;
        }

        return false;
    }
}
