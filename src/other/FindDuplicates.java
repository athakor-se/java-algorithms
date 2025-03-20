package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindDuplicates {

    public static int[] findDuplicaesV1(int[] array) {
        
        var duplicateElements = new ArrayList<Integer>();
        var elements = new HashMap<>();        
        for (int i = 0; i < array.length; i++) {
            if (elements.containsKey(array[i])) {
                duplicateElements.add(array[i]);
                continue;
            }
            elements.put(array[i], array[i]);
        }
        return duplicateElements.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FindDuplicates.findDuplicaesV1(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        System.out.println(Arrays.toString(FindDuplicates.findDuplicaesV1(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(FindDuplicates.findDuplicaesV1(new int[]{1, 1, 2, 2, 3, 3})));
    }
}