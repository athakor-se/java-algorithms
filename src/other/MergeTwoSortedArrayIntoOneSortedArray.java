package other;

import java.util.Arrays;
import java.util.HashSet;

class MergeTwoSortedArrayIntoOneSortedArray {

    public static int[] mergeArray(int array1[], int[] array2) {
        
        var l1 = array1.length;
        var l2 = array2.length;

        var combinedArray = new int[l1 + l2];
        System.arraycopy(array1, 0, combinedArray, 0, l1);
        System.arraycopy(array2, 0, combinedArray, l1, l2);
        
        var treeSet = new HashSet<Integer>();
        for (int i = 0; i < combinedArray.length; i++) {
            treeSet.add(combinedArray[i]);
        }
        return treeSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MergeTwoSortedArrayIntoOneSortedArray.mergeArray(new int[] {1, 3, 5}, new int[] {2, 4, 6})));
        System.out.println(Arrays.toString(MergeTwoSortedArrayIntoOneSortedArray.mergeArray(new int[] {1, 2, 3}, new int[] {})));
        System.out.println(Arrays.toString(MergeTwoSortedArrayIntoOneSortedArray.mergeArray(new int[] {}, new int[] {4, 5, 6})));
    }

}