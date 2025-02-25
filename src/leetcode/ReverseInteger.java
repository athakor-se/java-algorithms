package leetcode;

public class ReverseInteger {

    private static int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        return (reverse <= Integer.MAX_VALUE) && (reverse >= Integer.MIN_VALUE) ? (int) reverse : 0;
    }

    public static void main(String[] args) {
        ReverseInteger.reverse(1534236469);
    }
}
