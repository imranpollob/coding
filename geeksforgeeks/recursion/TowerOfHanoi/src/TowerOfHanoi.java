
public class TowerOfHanoi {

    public static void main(String[] args) {
        int disks = 3;
        move(disks, 'A', 'B', 'C');
    }

    /**
     * Moving disks from source tower to destination tower using an intermediate
     * tower
     * 
     * @param n number of disks
     * @param a source tower
     * @param b intermediate tower
     * @param c destination tower
     */
    private static void move(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move disk 1 from tower " + a + " to tower " + c);
            return;
        }
        // move disk from A to B, using C as a intermediate tower
        move(n - 1, a, c, b);
        // move disk from A to C
        System.out.println("Move move " + n + " from tower " + a + " to tower " + c);
        // move disk from B to C, using A as a intermediate tower
        move(n - 1, b, a, c);

    }

}
