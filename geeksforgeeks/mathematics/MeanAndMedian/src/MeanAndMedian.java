import java.util.Arrays;
import java.util.Collections;

public class MeanAndMedian {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 5, 3, 4, 1, 2, 6 };
		int len = nums2.length;

		System.out.println("Mean of num1: " + Arrays.stream(nums1).sum() / Arrays.stream(nums1).count());
		Arrays.sort(nums2);

		if (len % 2 == 0) {
			System.out.println("Median of nums2: " + (float) (nums2[len / 2 - 1] + nums2[len / 2]) / 2);
		} else {
			System.out.println("Median of nums2: " + nums2[len / 2]);
		}

	}

}
