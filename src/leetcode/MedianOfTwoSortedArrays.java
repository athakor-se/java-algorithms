package leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        var array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);

        Arrays.sort(array);

        var medLen = array.length / 2;

        if (array.length % 2 == 0) {
            return array[medLen] + array[medLen - 1];
        }
        return array[medLen / 2];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
