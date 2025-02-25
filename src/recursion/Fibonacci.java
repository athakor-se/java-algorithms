package recursion;

/**
 * @author athakor
 */
public class Fibonacci {

    //  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
