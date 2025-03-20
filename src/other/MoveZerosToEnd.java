package other;

import java.util.Arrays;

public class MoveZerosToEnd {

    private static int[] moveZeroToEnd(int[] array) {

        var lastUpdateIndex = -1;
        var transformedArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                transformedArr[++lastUpdateIndex] = array[i];
            }
        }
        return transformedArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroToEnd(new int[] { 0, 1, 1 })));
        System.out.println(Arrays.toString(moveZeroToEnd(new int[] { 1, 2, 3 })));
        System.out.println(Arrays.toString(moveZeroToEnd(new int[] { 0, 1, 0, 3, 12 })));
        System.out.println(Arrays.toString(moveZeroToEnd(new int[] { 1, 0, 8, 6, 0, 7, 0, 2, 3, 0 })));
    }

}
