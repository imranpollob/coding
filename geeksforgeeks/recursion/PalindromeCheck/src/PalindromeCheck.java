
public class PalindromeCheck {

	public static void main(String[] args) {
		String text = "popop";

		if (check(text, 0, text.length() - 1) == true) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}

	}

	private static boolean check(String text, int l, int r) {
		if (l > r) {
			return true;
		}

		if (text.charAt(l) == text.charAt(r)) {
			return check(text, l + 1, r - 1);
		} else {
			return false;
		}
	}

}
