
public class BubbleSort {

	public static void main(String[] args) {
        int[] arr = {12, 5, 1, 3, 4, 66, 99, 17, 7};

        int[] sorted_arr = sort(arr);

        for (int j : sorted_arr) {
            System.out.println(j);
        }
	}
	
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
