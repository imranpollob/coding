import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 8, 5, 3, 9, 1 };

		int l = 0;
		int r = arr.length - 1;

		mergeSort(arr, l, r);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}

	}

	public static void merge(int[] arr, int l, int m, int r) {
		/**
		 * Here we will perform 2 way merge.
		 * First we need to create two arrays from the given pointers
		 * I initially tried to perform operation on the given array directly.
		 * But as the original values gets overwritten so creating two new arrays is easier.
		 */
		int llen = m - l + 1;
		int rlen = r - m;
		int[] a = new int[llen];
		int[] b = new int[rlen];
		
		// creating first array
		for (int t = 0; t < llen; t++) {
			a[t] = arr[t + l];
		}
		// creating second array
		for (int t = 0; t < rlen; t++) {
			b[t] = arr[t + m + 1];
		}

		int i = 0;	// pointer for first array
		int j = 0;	// pointer for second array
		int k = l;	// pointer of original array
		
		// performing two way merge
		while (i < llen && j < rlen) {
			if (a[i] <= b[j]) {
				arr[k] = a[i];
				k++;
				i++;
			} else {
				arr[k] = b[j];
				k++;
				j++;
			}
		}

		// loops for collecting the leftover items 
		// not covered by the above while loop
		for (int t = i; t < llen; t++) {
			arr[k] = a[t];
			k++;
		}

		for (int t = j; t < rlen; t++) {
			arr[k] = b[t];
			k++;
		}
	}

}
