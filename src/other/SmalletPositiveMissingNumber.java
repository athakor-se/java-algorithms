package other;

import java.util.Arrays;
import java.util.stream.Collectors;

class SmalletPositiveMissingNumber {

    public static int getSmallestMissingPositive(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 1;
        }

        var minPositive = 1;
        var uniqueElements = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        while (uniqueElements.contains(minPositive)) {
            minPositive++;
        }
        return minPositive;
    }

    public static void main(String[] args) {
        System.out.println(SmalletPositiveMissingNumber.getSmallestMissingPositive(new int[]{1, 2, 4, 5}));
        System.out.println(SmalletPositiveMissingNumber.getSmallestMissingPositive(new int[]{3, 7, 1, 2, 8, 4, 5}));
        System.out.println(SmalletPositiveMissingNumber.getSmallestMissingPositive(new int[]{1}));
    }

}