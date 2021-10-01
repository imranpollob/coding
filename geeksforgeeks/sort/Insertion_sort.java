package geeksforgeeks.sort;
// https://www.youtube.com/watch?v=i-SKeOcBwko

public class Insertion_sort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
        return arr;
    }


    public static void main(String[] args) {
        int arr[] = {12, 5, 1, 3, 4, 66, 99, 17, 7};

        int[] sorted_arr = sort(arr);

        for (int i = 0; i < sorted_arr.length; i++) {
            System.out.println(sorted_arr[i]);
        }

    }
}
