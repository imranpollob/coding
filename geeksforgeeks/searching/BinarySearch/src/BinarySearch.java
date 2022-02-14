
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7, 9, 10, 13, 15, 20, 50, 51 };
        int key = 20;
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int m = (l + h) / 2;

            if (arr[m] == key) {
                System.out.println("Found at position " + m);
                break;
            } else if (key < arr[m]) {
                h = m - 1;

            } else {
                l = m + 1;
            }
        }
    }

}
