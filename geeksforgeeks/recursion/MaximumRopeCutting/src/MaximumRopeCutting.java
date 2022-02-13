
public class MaximumRopeCutting {

    static int cut(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;

        int res = Math.max(cut(n - a, a, b, c), Math.max(cut(n - b, a, b, c), cut(n - c, a, b, c)));

        if (res < 0)
            return -1;

        return res + 1;
    }

    public static void main(String[] args) {
        int n = 23, a = 11, b = 9, c = 12;

        System.out.println(cut(n, a, b, c));

        n = 9;
        a = 2;
        b = 2;
        c = 2;

        System.out.println(cut(n, a, b, c));
    }

}
