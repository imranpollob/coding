package geeksforgeeks.sort;

public class Selection_sort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {12, 5, 1, 3, 4, 66, 99, 17, 7};

        int[] sorted_arr = sort(arr);

        for (int j : sorted_arr) {
            System.out.println(j);
        }

    }
}
