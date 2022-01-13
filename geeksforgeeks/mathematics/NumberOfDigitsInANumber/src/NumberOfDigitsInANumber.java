
public class NumberOfDigitsInANumber {

	public static void main(String[] args) {
		int n = 2022;
		int c = 0;
		
		while(n != 0) {
			n = n / 10;
			c++;
		}

		System.out.println("Number of digits: " + c);
		// Other O(1) solution: log10(N) + 1
		System.out.println("Number of digits: " + (int) Math.floor(Math.log10(2022) + 1));		
	}

}
