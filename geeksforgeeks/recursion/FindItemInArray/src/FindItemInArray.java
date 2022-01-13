
public class FindItemInArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int x = 3;
		
		if (search(array, 0, array.length - 1, x) == true) {
			System.out.println("Item found");
		} else {
			System.out.println("Item not found");
		}
	}

	private static boolean search(int[] array, int l, int r, int x) {
		if (l > r) {
			return false;
		}
		
		if (array[l] == x) {
			return true;
		}
		
		if (array[r] == x) {
			return true;
		}
		
		return search(array, l + 1, r - 1, x);
	}

}
