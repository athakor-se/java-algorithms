package leetcode;

import java.util.HashMap;

public class FindKthPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {
        for (int i : arr) {
            if (i <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    public static int findKthPositive2(int[] arr, int k) {
        var map = new HashMap() {{
            for (int j = 0; j < arr.length; j++) {
                put(arr[j], arr[j]);
            }
        }};
        var index = 0;
        var counter = 1;
        var value = counter;
        while (index != k) {
            if (map.get(counter) == null) {
                ++index;
                value = counter;
            }
            counter++;
        }
        return value;
    }

    public static void main(String[] args) {
        FindKthPositiveNumber.findKthPositive(new int[]{2, 3, 4, 7, 11}, 2);
    }
}
