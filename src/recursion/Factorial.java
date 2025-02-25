package recursion;

/**
 * @author athakor
 */
public class Factorial {

    // 1 × 2 × 3 × 4 × 5 × 6 × 7

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    private static int factorial(int n) {
        if (n == 1)
            return n;
        return n * factorial(n - 1);
    }
}
