
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 24, 18, 62, 8, 4, 65, 2, 684, 64, 86, 498, 64 };
        int key = 2;

        System.out.println("Found at position " + search(arr, key));
    }

    public static int search(int[] arr, int key) {
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

}
