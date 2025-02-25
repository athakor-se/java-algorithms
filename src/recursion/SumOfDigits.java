package recursion;

/**
 * @author athakor
 */
public class SumOfDigits {

    // 1+2+3+4+5+6

    public static void main(String[] args) {
        System.out.println(sumOfDigits(10));
    }

    private static int sumOfDigits(int n) {
        if (n == 1)
            return n;
        return n + sumOfDigits(n - 1);
    }
}
