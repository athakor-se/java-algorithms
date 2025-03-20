package other;

import java.util.Arrays;

public class PairWithGivenSum {

    private static int[] findPairForSum(int[] elements, int sum) {

        var left = 0;
        for (int right = 1; right < elements.length; right++) {
            if (elements[left] + elements[right] == sum) {
                return new int[] { elements[left], elements[right] };
            }
            left = left + 1;
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PairWithGivenSum.findPairForSum(new int[] { 2, 7, 11, 15 }, 9)));
        System.out.println(Arrays.toString(PairWithGivenSum.findPairForSum(new int[] { 1, 2, 3, 4, 5 }, 10)));
        System.out.println(Arrays.toString(PairWithGivenSum.findPairForSum(new int[] { 3, 3 }, 6)));
    }
}
