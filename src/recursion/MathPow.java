package recursion;

/**
 * @author athakor
 */
public class MathPow {

    public static void main(String[] args) {
        System.out.println(power(3, 4));
    }

    private static int power(int x, int y) {
        if (y == 1)
            return x;
        return x * power(x, y - 1);
    }
}
