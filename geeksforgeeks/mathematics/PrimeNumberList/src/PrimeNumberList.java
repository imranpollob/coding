
public class PrimeNumberList {

	public static void main(String[] args) {
		int n = 1000;
		int[] list = new int[n - 1];

		for (int i = 2; i <= n - 1; i++) {
			list[i - 2] = i;
		}

		int cur = list[0];

		while (cur * cur < n) {
			if (list[cur - 2] == 0) {
				cur++;
				continue;
			}

			for (int i = cur * cur; i < n; i = i + cur) {
				list[i - 2] = 0;
			}

			cur++;
		}

		for (int i : list) {
			if (i != 0) {
				System.out.println(i);
			}
		}

	}

}
