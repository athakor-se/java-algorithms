package leetcode;

import java.util.Arrays;

/**
 * @author athakor
 */
public class MostRepetitiveElement {

    public static void main(String[] args) {
        var array = new int[]{4, 2, 4, 9, 6, 8, 5, 6, 7, 5};
        var element = findRepetitiveElement(array);
        System.out.println(element);
    }

    private static int findRepetitiveElement(int[] array) {
        var maxNumber = Arrays.stream(array).boxed().max(Integer::compareTo).get();
        var frequencies = new int[maxNumber + 1];
        var maxFrequency = 0;
        var element = -1;
        for (Integer i : array) {
            frequencies[i]++;
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
                element = i;
            }
        }
        return element;
    }
}
