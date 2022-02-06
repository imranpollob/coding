import java.util.Arrays;

public class TwoWayMerge {
	public static void merge() {
		int[] a = { 2, 8, 15, 18, 18, 19 };
		int[] b = { 5, 9, 12, 17, 18, 20, 21, 25 };
		int[] c = new int[a.length + b.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k] = a[i];
				k++;
				i++;
			} else {
				c[k] = b[j];
				k++;
				j++;
			}
		}

		for (int t = i; t < a.length; t++) {
			c[k] = a[t];
			k++;
		}

		for (int t = j; t < b.length; t++) {
			c[k] = b[t];
			k++;
		}

		System.out.println(Arrays.toString(c));
	}

}
