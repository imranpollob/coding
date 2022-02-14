
public class SumOfDigits {

    public static void main(String[] args) {
        int a = 1234;

        System.out.println(digitSum(a));
    }

    private static int digitSum(int a) {
        if (a == 0)
            return 0;

        return digitSum(a / 10) + (a % 10);
    }
}
