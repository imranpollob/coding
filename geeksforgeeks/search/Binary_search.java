package geeksforgeeks.search;

public class Binary_search {
    public static int search(int[] arr, int key, int left, int right) {
        if (left >= right) return -1;

        int middle = (left + right) / 2;

        if (arr[middle] == key) {
            return middle;
        } else if (key < arr[middle]) {
            return search(arr, key, left, middle - 1);
        } else {
            return search(arr, key, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 10, 13, 15, 20, 50, 51};
        int key = 20;

        System.out.println(search(arr, key, 0, arr.length - 1));
    }
}
