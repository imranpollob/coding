import java.util.ArrayList;
import java.util.Iterator;

public class OpenAddressing {
    int bucket;
    int[] arr;

    public OpenAddressing(int val) {
        bucket = val;
        arr = new int[val];
    }

    public static void main(String[] args) {
        OpenAddressing op = new OpenAddressing(7);
        op.printArray();
        
        op.insert(49);
        op.insert(56);
        op.insert(64);
        op.insert(73);

        op.printArray();
        
        System.out.println("Found at: " + op.search(56));
    }
    
    private int search(int val) {
        int pos = hash(val);

        for (int i = 0; i < bucket; i++) {
            int cur = hash(pos + i);
            
            if (arr[cur] == 0) {
                return -1;
            } else if (arr[cur] == val){
                return cur;
            }
            
        }
        
        return -1;
    }

    private void printArray() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int hash(int val) {
        return val % bucket;
    }

    private void insert(int val) {
        int pos = hash(val);

        for (int i = 0; i < bucket; i++) {
            int cur = hash(pos + i);
            
            if(arr[cur] == 0) {
                arr[cur] = val;
                break;
            }
        }
    }

}
