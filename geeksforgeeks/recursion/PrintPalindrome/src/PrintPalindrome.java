
public class PrintPalindrome {

    public static void main(String[] args) {
        String s = "abc";

        print(s, 0);
    }

    private static void print(String s, int l) {
        if (l == s.length())
            return;

        System.out.print(s.charAt(l) + " ");

        print(s, l + 1);

        System.out.print(s.charAt(l) + " ");
    }

}
