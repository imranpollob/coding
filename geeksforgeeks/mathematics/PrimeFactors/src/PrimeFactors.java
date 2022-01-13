import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PrimeFactors {

	public static void main(String[] args) {
		int n = 15000;
		int temp = (int) Math.sqrt(n);

		ArrayList<Integer> prime_factors = new ArrayList<Integer>();

		int i = 2;
		while (i <= temp) {
			if (n % i == 0) {
				n = n / i;
				prime_factors.add(i);
				continue;
			}

			i++;
		}

		int result = 1;

		for (int j : prime_factors) {
			result *= j;
		}

		System.out.println(prime_factors);
		System.out.println(result);

	}

}
